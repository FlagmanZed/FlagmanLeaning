package RoleGame;

public class GameScene {
    Players player;
    Location location;
    private int mainCommand, countMove;

    GameScene(Players player) {
        this.player = player;
    }

    //    Главная сцена действий в городе
    void mainTownScene() {
        countMove++;
        GameMenu.mainTownMenu();
        mainCommand = GameMenu.Assist.makeRightChoice(0, 8);
        switch (mainCommand) {
            case 1 -> {
                player.print(player);
                mainTownScene();
            }
            case 2 -> {
                sleepScene();
                mainTownScene();
            }
            case 3 -> {
//                System.out.println("Торговец не вышел на работу, может это Covid`19?");
//                System.out.println();
//                mainTownScene();
                location = new Town();
                ((DealerPotion) location.npc).showProduct();
                GameMenu.sellMenu();
                int tmp = GameMenu.Assist.makeRightChoice(0, 1);
                if (tmp != 0) ((DealerPotion) location.npc).sellProduct(player);
                mainTownScene();
            }
            case 4, 5, 6, 7 -> {
                location = choiceLocationScene();
                mainLocationScene();
            }
            case 8 -> {
                if (countMove > 100)
                    System.out.println("Вы терпеливо следовали своему Пути, и заслужили на пенсии большое уважение");
                else if (countMove > 10)
                    System.out.println("Вы сполна прошли по Пути, и заслуженный отдых будет вам наградой");
                else System.out.println("Путь гораздо длиннее, чем прошли вы, попахивает дезертирством....");
            }
            case 0 -> {
                mainCommand = 10;
                if (player.backpak.show().equals("nothing")) {
                    System.out.println("В рюкзаке ничего нет");
                } else {
                    System.out.println(player.backpak.show());
                    GameMenu.inventoryMenuChoice();
                    backpackScene();
                }
                mainTownScene();
            }
        }
    }

    //  Восстановление сил дома
    void sleepScene() {
        player.goSleep();
    }

    //    Сцена действий в выбранной локации
    void mainLocationScene() {
        countMove++;
        System.out.println(location.name);
        if (location.monster == null) System.out.println("В ближайших окрестностях никого не обнаружено");
        else System.out.println("Вами замечен " + location.monster.name + " " + location.monster.level + " уровня");
        GameMenu.locationMenu();
        int locCommand = GameMenu.Assist.makeRightChoice(0, 6);
        switch (locCommand) {
            case 1 -> {
                player.print(player);
                mainLocationScene();
            }
            case 2 -> {
                if (location.monster == null) System.out.println("Тут некого рассматривать");
                else location.monster.print(location.monster);
                mainLocationScene();
            }
            case 3 -> {
                if (location.monster == null) System.out.println("Тут некого атаковать");
                else {
                    player.attack(player, location.monster);
                    if (location.monster.hp <= 0) location.monster = null;
                }
                if (player.isDead() && player.lives < 0) GameMenu.gameOver();
                else mainLocationScene();
            }
            case 4 -> {
                intelligenceLocation();
                mainLocationScene();
            }
            case 5 -> {
                if (mainCommand == 4) location = new Mountain();
                else if (mainCommand == 5) location = new Forest();
                else if (mainCommand == 6) location = new Swamp();
                else location = new Dungeon();
                mainLocationScene();
            }
            case 6 -> mainTownScene();
            case 0 -> {
                mainCommand = 20;
                if (player.backpak.show().equals("nothing")) {
                    System.out.println("В рюкзаке ничего нет");
                } else {
                    System.out.println(player.backpak.show());
                    GameMenu.inventoryMenuChoice();
                    backpackScene();
                }
                mainLocationScene();
            }
        }
    }

    //    Сцена действий с инвентарем
    void backpackScene() {
        int choiceItemCommand = GameMenu.Assist.makeRightChoice(0, 1);
        switch (choiceItemCommand) {
            case 1 -> {
                Items item = player.backpak.changeItem();
                GameMenu.inventoryMenuUse();
                int useCommand = GameMenu.Assist.makeRightChoice(0, 2);
                switch (useCommand) {
                    case 1 -> {
                        player.use(item);
                        if (mainCommand == 10) mainTownScene();
                        else mainLocationScene();
                    }
                    case 2 -> {
                        player.backpak.drop(item);
                        System.out.println("Предмет " + item.name + " выброшен");
                    }
                    case 0 -> {
                        if (mainCommand == 10) mainTownScene();
                        else mainLocationScene();
                    }
                }
            }
            case 0 -> {
                if (mainCommand == 10) mainTownScene();
                else mainLocationScene();
            }
        }
    }

    //    Определение локации
    Location choiceLocationScene() {
        if (mainCommand == 4) return new Mountain();
        else if (mainCommand == 5) return new Forest();
        else if (mainCommand == 6) return new Swamp();
        else return new Dungeon();
    }

    //    Поиск предметов на локации
    void intelligenceLocation() {
        countMove++;
        Items something;
        int percent = (int) (Math.random() * 100 + 1);
        if (percent > 0 && percent <= 50) something = new Potion();
        else if (percent > 50 && percent <= 75) something = new OneWeapon();
        else something = new DualWeapon();
        if ((int) (Math.random() * 100 + 1) < 15) {
            System.out.println("Внимательно изучая местность вы обнаружили тайник, а в нем: " + something.name + " " + something.level + " уровня");
            GameMenu.takeMenu();
            int tmp = GameMenu.Assist.makeRightChoice(0, 2);
            if (tmp == 0) mainLocationScene();
            else if (tmp == 1) player.use(something);
            else {
                if (!player.backpak.isFull()) {
                    player.backpak.take(something);

                } else {
                    System.out.println("Рюкзак заполнен");
                    GameMenu.exchangeMenu();
                    int tmpCommand = GameMenu.Assist.makeRightChoice(0, 1);
                    switch (tmpCommand) {
                        case 1 -> {
                            System.out.println(player.backpak.show());
                            Items item = player.backpak.changeItem();
                            player.backpak.drop(item);
                            player.backpak.take(something);
                        }
                        case 0 -> mainLocationScene();
                    }
                }
            }
        } else {
            if (location.monster == null)
                System.out.println("Поиски не привели к успеху, может не очень внимательно искали?");
            else
                System.out.println("Не привлекая внимание " + location.monster.name + " " + location.monster.level + " вы произвели тщательную разведку местности, но ничего не обнаружили");
        }
    }
}