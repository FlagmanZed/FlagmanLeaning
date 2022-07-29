package RoleGeme;

public class Players extends BattlePersonage implements Attacking, Useable {

    int cloneHP, lives;

    Head head;
    Hand leftHand, rightHand;
    Body body;
    Leg leftLeg, rightLeg;
    Backpak backpak;

    Players(String name) {
        super(name);
        head = new Head();
        leftHand = new Hand();
        rightHand = new Hand();
        body = new Body();
        leftLeg = new Leg();
        rightLeg = new Leg();
        backpak = new Backpak();
        gold = 100;
        exp = 0;
        level = 10;
        lives = 3;
    }

    @Override
    public void use(Items item) {
        if (level >= item.level) {
            if (item.classMarker.equals(classMarker)) {
                switch (item.typeMarker) {
                    case "handsArm" -> {
                        rightHand.armour = leftHand.armour = (HandArmour) item;
                        defense = dexterity + rightHand.armour.defense;
                        System.out.println("�� ������ " + item.name);
                    }
                    case "oneHandWep" -> {
                        if (rightHand.weapon.typeMarker.equals("dualHandWep")) {
                            System.out.println("�� ������� ��������� ������ " + rightHand.weapon.name + ", ������ � ������ ���� " + item.name);
                            rightHand.weapon = (Weapon) item;
                            leftHand.weapon = new OneWeapon("�����");
                        } else {
                            if (rightHand.weapon.name.equals("�����")) {
                                rightHand.weapon = (Weapon) item;
                                System.out.println("�� ����� � ������ ���� " + item.name);
                            } else if (leftHand.weapon.name.equals("�����")) {
                                leftHand.weapon = (Weapon) item;
                                System.out.println("�� ����� � ����� ���� " + item.name);
                            } else {
                                if (((Weapon) item).power > rightHand.weapon.power) {
                                    System.out.println("�� ������� " + rightHand.weapon.name + ", ������ � ������ ���� " + item.name);
                                    rightHand.weapon = (Weapon) item;
                                } else if (((Weapon) item).power > leftHand.weapon.power) {
                                    System.out.println("�� ������� " + leftHand.weapon.name + ", ������ � ����� ���� " + item.name);
                                    leftHand.weapon = (Weapon) item;
                                } else {
                                    leftHand.weapon = (Weapon) item;
                                    System.out.println("�� ������� " + leftHand.weapon.name + ", ������ � ����� ���� " + item.name);
                                }
                            }
                        }
                        attack = strength + rightHand.weapon.power + leftHand.weapon.power;
                    }
                    case "dualHandWep" -> {
                        rightHand.weapon = leftHand.weapon = (Weapon) item;
                        attack = strength + rightHand.weapon.power;
                        System.out.println("������ �� ����������� ��������� ������ " + item.name);
                    }
                }
            } else System.out.println("�������� �� ����� ������������ ���");
        } else System.out.println("������������� ������� ��� �������������");
    }

    void goSleep() {
        if (hp < cloneHP) {
            System.out.println("�� ���� ��������");
            hp = cloneHP;
            GameMenu.Choice.pause(3000);
            System.out.println("�� ������� ��������� � ��������� ��������� ���� ��������");
        } else System.out.println("�� �����, ����� ��� � �� ���������� � ������");
    }

    int levelUp() {
        int countExp = 0;
        for (int i = 1; i <= level; i++) {
            countExp += i * 100;
            if (i == level) break;
        }
        if (exp >= countExp && level <= 10) {
            level++;
            System.out.println("�� �������� ������ " + level + " � ���� �������������� ����������");
            hp = (cloneHP + level * 15);
            strength += 10;
            dexterity += 5;
            cloneHP = hp;
        }
        return countExp;
    }

    @Override
    void print(BattlePersonage pers) {
        super.print(this);
        System.out.println("�� ���������� ������� - " + (levelUp() - exp));
        System.out.println("������ � �������� - " + gold);
        System.out.println();
    }

    private class Hand {

        Weapon weapon;
        HandArmour armour;

        Hand() {
            weapon = new OneWeapon("�����");
            armour = new HandArmour("��� ����������");
        }
    }

    private class Head {

        Armour[] helm;

        Head() {
            helm = new Armour[1];
        }
    }

    private class Body {

        Armour[] chainArm;

        Body() {
            chainArm = new Armour[1];
        }
    }

    private class Leg {

        Armour[] pantArm;

        Leg() {
            pantArm = new Armour[1];
        }
    }

}

