package RoleGeme;

/* Класс для создания персонажа игрока.
   Каждый персонаж может носить снаряжение, использовать оружие
   и переносить 5 предметов в рюкзаке.
 */
public class Players extends BattlePersonage implements Attacking, Useable {

    protected int cloneHP, lives;

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
        level = 1;
        lives = 3;
    }

    // Персонаж может использовать снаряжение увеличивающее защиту и оружие увеличивающее атаку
    @Override
    public void use(Items item) {
        // проверяем соответсвие уровня аммуниции уровню персонажа
        if (level >= item.level) {
            // проверяем может ли игровой класс персонажа использовать аммуницию
            if (item.classMarker.equals(classMarker) || item.classMarker.equals("all")) {
                switch (item.typeMarker) {
                    case "potionHP" -> {
                        if (hp >= cloneHP)
                            System.out.println("Вам незачем принимать " + item.name + ", вы совершенно здоровы");
                        else if (hp + ((Potion) item).recoveryHP < cloneHP) {
                            hp += ((Potion) item).recoveryHP;
                            backpak.drop(item);
                            System.out.println("Вы приняли " + item.name + ", и восстановили " + ((Potion) item).recoveryHP + " единиц здоровья");
                        } else if (hp + ((Potion) item).recoveryHP >= cloneHP) {
                            hp = cloneHP;
                            backpak.drop(item);
                            System.out.println("Вы приняли " + item.name + ", и полностью восстановили здоровье");
                        }
                    }
                    case "handsArm" -> {
                        if (rightHand.armour.name.equals("Нет снаряжения")) {
                            backpak.drop(item);
                        } else backpak.exchange(rightHand.weapon, item);
                        rightHand.armour = leftHand.armour = (HandArmour) item;
                        defense = dexterity + rightHand.armour.defense;
                        System.out.println("Вы надели " + item.name);
                    }
                    case "oneHandWep" -> {
                        if (rightHand.weapon.typeMarker.equals("dualHandWep")) {
                            System.out.println("Вы сменили двуручное оружие " + rightHand.weapon.name + ", теперь в правой руке " + item.name);
                            backpak.exchange(rightHand.weapon, item);
                            rightHand.weapon = (Weapon) item;
                            leftHand.weapon = new OneWeapon("Кулак");
                        } else {
                            if (rightHand.weapon.name.equals("Кулак")) {
                                backpak.drop(item);
                                rightHand.weapon = (Weapon) item;
                                System.out.println("Вы взяли в правую руку " + item.name);
                            } else if (leftHand.weapon.name.equals("Кулак")) {
                                backpak.drop(item);
                                leftHand.weapon = (Weapon) item;
                                System.out.println("Вы взяли в левую руку " + item.name);
                            } else {
                                if (((Weapon) item).power > rightHand.weapon.power) {
                                    System.out.println("Вы сменили " + rightHand.weapon.name + ", теперь в правой руке " + item.name);
                                    backpak.exchange(rightHand.weapon, item);
                                    rightHand.weapon = (Weapon) item;
                                } else if (((Weapon) item).power > leftHand.weapon.power) {
                                    System.out.println("Вы сменили " + leftHand.weapon.name + ", теперь в левой руке " + item.name);
                                    backpak.exchange(leftHand.weapon, item);
                                    leftHand.weapon = (Weapon) item;
                                } else {
                                    backpak.exchange(leftHand.weapon, item);
                                    leftHand.weapon = (Weapon) item;
                                    System.out.println("Вы сменили " + leftHand.weapon.name + ", теперь в левой руке " + item.name);
                                }
                            }
                        }
                        attack = strength + rightHand.weapon.power + leftHand.weapon.power;
                    }
                    case "dualHandWep" -> {
                        if (rightHand.weapon.name.equals("Кулак") && leftHand.weapon.name.equals("Кулак")) {
                            backpak.drop(item);
                        } else if (rightHand.weapon.name.equals("Кулак") && !leftHand.weapon.name.equals("Кулак")) {
                            backpak.exchange(leftHand.weapon, item);
                        } else if (!rightHand.weapon.name.equals("Кулак") && leftHand.weapon.name.equals("Кулак")) {
                            backpak.exchange(rightHand.weapon, item);
                        } else {
                            backpak.exchange(rightHand.weapon, item);
                            backpak.take(leftHand.weapon);
                        }
                        rightHand.weapon = leftHand.weapon = (Weapon) item;
                        attack = strength + rightHand.weapon.power;
                        System.out.println("Теперь вы используете двуручное оружие " + item.name);
                    }
                }
            } else System.out.println("Персонаж не может использовать это");
        } else System.out.println("Недостаточный уровень для использования");
    }

    void goSleep() {
        if (hp < cloneHP) {
            System.out.println("Вы ушли отдыхать");
            hp = cloneHP;
            GameMenu.Assist.pause(3000);
            System.out.println("Вы отлично отдохнули и полностью поправили свое здоровье");
        } else System.out.println("Вы свежи, полны сил и не нуждаетесь в отдыхе");
    }

    int levelUp() {
        int countExp = 0;
        for (int i = 1; i <= level; i++) {
            countExp += i * 100;
            if (i == level) break;
        }
        if (exp >= countExp && level <= 10) {
            level++;
            System.out.println("Вы достигли уровня " + level + " и ваши характеристики улучшились");
            hp = (cloneHP + level * 15);
            strength += 10;
            dexterity += 5;
            cloneHP = hp;
        }
        return countExp;
    }

    boolean isDead() {
        return hp <= 0;
    }

    @Override
    void print(BattlePersonage pers) {
        super.print(this);
        System.out.println("Атака - " + attack);
        System.out.println("Защита - " + defense);
        System.out.print("Используемое оружие: ");
        if (rightHand.weapon.typeMarker.equals("dualHandWep")) System.out.println(rightHand.weapon.name + " + " + rightHand.weapon.power + " к силе");
        else if (rightHand.weapon.name.equals("Кулак") && leftHand.weapon.name.equals("Кулак"))
            System.out.println("Кулаки");
        else if (rightHand.weapon.name.equals("Кулак"))
            System.out.println(leftHand.weapon.name + " + " + leftHand.weapon.power + " к силе");
        else if (leftHand.weapon.name.equals("Кулак"))
            System.out.println(rightHand.weapon.name + " + " + rightHand.weapon.power + " к силе");
        else
            System.out.println(rightHand.weapon.name + " и " + leftHand.weapon.name + " + " + (rightHand.weapon.power + leftHand.weapon.power) + " к силе");
        System.out.println("До следующего уровеня - " + (levelUp() - exp));
        System.out.println("Золота в кошельке - " + gold);
        System.out.println();
    }

    private class Hand {

        Weapon weapon;
        HandArmour armour;

        Hand() {
            weapon = new OneWeapon("Кулак");
            armour = new HandArmour("Нет снаряжения");
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

