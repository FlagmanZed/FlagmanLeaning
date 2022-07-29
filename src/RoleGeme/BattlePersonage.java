package RoleGeme;

public class BattlePersonage extends Personage implements Attacking {

    String classMarker;
    int strength, dexterity;
    int hp, attack, defense;
    int level, exp;

    BattlePersonage(String name) {
        super(name);
    }

    @Override
    public void attack(BattlePersonage hero, BattlePersonage monster) {
        BattlePersonage attackPers;
        BattlePersonage defensePers;
        int moveCount = 1;
        if ((int) (Math.random() * 100 + 1) < 5) {
            System.out.println(monster.name + " оказался быстрее" + hero.name + " и наносит удар первым");
            attackPers = monster;
            defensePers = hero;
        } else {
            System.out.println(hero.name + " незаметно подкрался к " + monster.name + " и наносит удар первым");
            attackPers = hero;
            defensePers = monster;
        }
        while (attackPers.hp > 0 && defensePers.hp > 0) {
            System.out.println("=== Ход " + moveCount + " ===");
            if (attackPers.level > defensePers.level + 3) {
                defensePers.hp -= (attackPers.attack * 2);
                attackPers.hp -= (defensePers.attack / 2);
            }else if (defensePers.level > attackPers.level + 3){
                defensePers.hp -= (attackPers.attack / 2);
                attackPers.hp -= (defensePers.attack * 2);
            }
            else {
                defensePers.hp -= attackPers.attack;
                attackPers.hp -= defensePers.attack;
            }

            if (defensePers.hp > 0 && attackPers.hp > 0) {
                System.out.println(attackPers.name + " бьет и у " + defensePers.name + " осталось " + defensePers.hp);
                System.out.println(defensePers.name + " бьет и у " + attackPers.name + " осталось " + attackPers.hp);
            } else if (defensePers.hp > 0 && attackPers.hp <= 0)
                System.out.println(defensePers.name + " бьет и побеждает " + attackPers.name);
            else System.out.println(attackPers.name + " бьет и побеждает " + defensePers.name);

            moveCount++;
            GameMenu.Choice.pause(1000);
        }
        if (hero.hp <= 0) {
            ((Players) hero).lives--;
            System.out.println("Вы потратили жизнь, осталось еще " + ((Players) hero).lives);
            ((Players) hero).hp = ((Players) hero).cloneHP;
        } else {
            ((Players) hero).exp += ((Monsters) monster).exp;
            ((Players) hero).gold += ((Monsters) monster).gold;
            System.out.println(((Players) hero).name + " набрал " + ((Monsters) monster).exp + " опыта, и затрофеил  " + ((Monsters) monster).gold + " золотишка!");
            ((Players) hero).levelUp();
        }
    }

    void print(BattlePersonage pers) {
        System.out.println("Характеристики: " + pers.name);
        System.out.println("Уровень - " + pers.level);
        System.out.println("Здоровье - " + pers.hp);
        System.out.println("Сила - " + pers.strength);
        System.out.println("Ловкость - " + pers.dexterity);
    }
}
