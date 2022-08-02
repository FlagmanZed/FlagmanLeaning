package RoleGame;

public class GameScene {
    Players player;
    Location location;
    private int mainCommand, countMove;

    GameScene(Players player) {
        this.player = player;
    }

    //    ������� ����� �������� � ������
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
//                System.out.println("�������� �� ����� �� ������, ����� ��� Covid`19?");
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
                    System.out.println("�� ��������� ��������� ������ ����, � ��������� �� ������ ������� ��������");
                else if (countMove > 10)
                    System.out.println("�� ������ ������ �� ����, � ����������� ����� ����� ��� ��������");
                else System.out.println("���� ������� �������, ��� ������ ��, ���������� �������������....");
            }
            case 0 -> {
                mainCommand = 10;
                if (player.backpak.show().equals("nothing")) {
                    System.out.println("� ������� ������ ���");
                } else {
                    System.out.println(player.backpak.show());
                    GameMenu.inventoryMenuChoice();
                    backpackScene();
                }
                mainTownScene();
            }
        }
    }

    //  �������������� ��� ����
    void sleepScene() {
        player.goSleep();
    }

    //    ����� �������� � ��������� �������
    void mainLocationScene() {
        countMove++;
        System.out.println(location.name);
        if (location.monster == null) System.out.println("� ��������� ������������ ������ �� ����������");
        else System.out.println("���� ������� " + location.monster.name + " " + location.monster.level + " ������");
        GameMenu.locationMenu();
        int locCommand = GameMenu.Assist.makeRightChoice(0, 6);
        switch (locCommand) {
            case 1 -> {
                player.print(player);
                mainLocationScene();
            }
            case 2 -> {
                if (location.monster == null) System.out.println("��� ������ �������������");
                else location.monster.print(location.monster);
                mainLocationScene();
            }
            case 3 -> {
                if (location.monster == null) System.out.println("��� ������ ���������");
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
                    System.out.println("� ������� ������ ���");
                } else {
                    System.out.println(player.backpak.show());
                    GameMenu.inventoryMenuChoice();
                    backpackScene();
                }
                mainLocationScene();
            }
        }
    }

    //    ����� �������� � ����������
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
                        System.out.println("������� " + item.name + " ��������");
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

    //    ����������� �������
    Location choiceLocationScene() {
        if (mainCommand == 4) return new Mountain();
        else if (mainCommand == 5) return new Forest();
        else if (mainCommand == 6) return new Swamp();
        else return new Dungeon();
    }

    //    ����� ��������� �� �������
    void intelligenceLocation() {
        countMove++;
        Items something;
        int percent = (int) (Math.random() * 100 + 1);
        if (percent > 0 && percent <= 50) something = new Potion();
        else if (percent > 50 && percent <= 75) something = new OneWeapon();
        else something = new DualWeapon();
        if ((int) (Math.random() * 100 + 1) < 15) {
            System.out.println("����������� ������ ��������� �� ���������� ������, � � ���: " + something.name + " " + something.level + " ������");
            GameMenu.takeMenu();
            int tmp = GameMenu.Assist.makeRightChoice(0, 2);
            if (tmp == 0) mainLocationScene();
            else if (tmp == 1) player.use(something);
            else {
                if (!player.backpak.isFull()) {
                    player.backpak.take(something);

                } else {
                    System.out.println("������ ��������");
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
                System.out.println("������ �� ������� � ������, ����� �� ����� ����������� ������?");
            else
                System.out.println("�� ��������� �������� " + location.monster.name + " " + location.monster.level + " �� ��������� ���������� �������� ���������, �� ������ �� ����������");
        }
    }
}