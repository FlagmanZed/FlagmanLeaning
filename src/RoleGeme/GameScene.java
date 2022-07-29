package RoleGeme;

public class GameScene {
    Players player;
    Location location;
    int mainCommand;

    GameScene(Players player) {
        this.player = player;
    }

    void mainTownScene() {
        GameMenu.mainTownMenu();
        mainCommand = GameMenu.Choice.makeRightChoice(0, 8);
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
                System.out.println("Торговец не вышел на работу, может это Covid`19?");
                System.out.println();
                mainTownScene();
            }
            case 4, 5, 6, 7 -> {
                location = choiceLocationScene();
                mainLocationScene();
            }
            case 8 -> System.out.println("Игра окончена");
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

    void scene1() {

    }

    void sleepScene() {
        player.goSleep();
    }

    void scene3() {
    }

    void mainLocationScene() {
        System.out.println(location.name);
        if (location.monster == null) System.out.println("В ближайших окрестностях никого не обнаружено");
        else System.out.println("Вами замечен " + location.monster.name + " " + location.monster.level + " уровня");
        GameMenu.locationMenu();
        int locCommand = GameMenu.Choice.makeRightChoice(0, 6);
        switch (locCommand) {
            case 1 -> {
                player.print(player);
                mainLocationScene();
            }
            case 2 -> {
                if (location.monster == null) System.out.println("Тут некого рассматривать");
                else player.print(location.monster);
                mainLocationScene();
            }
            case 3 -> {
                if (location.monster == null) System.out.println("Тут некого атаковать");
                else {
                    player.attack(player, location.monster);
                    if (location.monster.hp <= 0) location.monster = null;
                }
                mainLocationScene();
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
            default -> {
                mainCommand = 20;
                if (player.backpak.show().equals("nothing")) {
                    System.out.println("В рюкзаке ничего нет");
                } else {
                    System.out.println(player.backpak.show());
                    GameMenu.inventoryMenuChoice();
                    backpackScene();
                }
            }
        }
    }

    void backpackScene() {
        int choiceItemCommand = GameMenu.Choice.makeRightChoice(0, 1);
        switch (choiceItemCommand) {
            case 1 -> {
                Items item = player.backpak.changeItem();
                GameMenu.inventoryMenuUse();
                int useCommand = GameMenu.Choice.makeRightChoice(0, 2);
                switch (useCommand) {
                    case 1 -> {
                        player.use(item);
                        if (mainCommand == 10) mainTownScene();
                        else mainLocationScene();
                    }
                    case 2 -> player.backpak.drop(item);
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

    Location choiceLocationScene() {
        if (mainCommand == 4) return new Mountain();
        else if (mainCommand == 5) return new Forest();
        else if (mainCommand == 6) return new Swamp();
        else return new Dungeon();
    }

    void intelligenceLocation() {
        Weapon weapon;
        if ((int) (Math.random() * 100 + 1) < 30) weapon = new DualWeapon();
        else weapon = new OneWeapon();
        if ((int) (Math.random() * 100 + 1) < 15) {
            System.out.println("Внимательно изучая местность вы обнаружили тайник, а в нем: " + weapon.name + " " + weapon.level + " уровня");
            GameMenu.takeMenu();
            int tmp = GameMenu.Choice.makeRightChoice(0, 2);
            if (tmp == 0) mainLocationScene();
            else if (tmp == 1) player.use(weapon);
            else {
                player.backpak.take(weapon);
                if (player.backpak.isEmpty()) GameMenu.takeMenu();
            }
        } else {
            if (location.monster == null)
                System.out.println("Поиски не привели к успеху, может не очень внимательно искали?");
            else
                System.out.println("Не привлекая внимание " + location.monster.name + " " + location.monster.level + " вы произвели тщательную разведку местности, но ничего не обнаружили");
        }
    }
}