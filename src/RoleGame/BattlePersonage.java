package RoleGame;
/*  Ёто класс дл€ всех персонажей, которые могут
    принимать участие в схватке.
    ¬ арсенале два метода - атака и смотр характеристик
*/

public abstract class BattlePersonage extends Personage implements Attacking {

    protected String classMarker;
    protected int strength, dexterity;
    protected int hp, attack, defense;
    protected int level, exp;

    BattlePersonage(String name) {
        super(name);
    }

    @Override
    public void attack(BattlePersonage hero, BattlePersonage monster) {
//        –асконсервируй дл€ запуска атаки в отдельном потоке
/*        Runnable runnable = () -> {*/

//            ќпредел€ем атакующего и защищающегос€
        BattlePersonage attackPers;
        BattlePersonage defensePers;
        int moveCount = 1;
//            — веро€тностью 90% нападающим будет персонаж игрока
        if ((int) (Math.random() * 100 + 1) <= 10) {
            System.out.println(monster.name + " оказалс€ быстрее " + hero.name + " и наносит удар первым");
            attackPers = monster;
            defensePers = hero;
        } else {
            System.out.println(hero.name + " незаметно подкралс€ к " + monster.name + " и наносит удар первым");
            attackPers = hero;
            defensePers = monster;
        }
//            «апускаем цикл поочередного нанесени€ ударов. ѕервым бьет атакующий.
//            ¬ случае, если уровень одного из участников битвы на 3 больше другого
//            то этот участник нанесет двойной урон, и получит урон в два раза меньше
        while (attackPers.hp > 0 && defensePers.hp > 0) {
            int rand;
            int whatPrint = 2;
            boolean isAttack;
            System.out.println("=== ’од " + moveCount + " ===");
            if (attackPers.level > defensePers.level + 3) defensePers.hp -= (attackPers.attack * 2);
            else if (defensePers.level > attackPers.level + 3) defensePers.hp -= (attackPers.attack / 2);
            else {
                rand = (int) (Math.random() * 100 + 1);
                isAttack = attackPers.dexterity * 3 > rand;
                if (isAttack && rand >= 93) {
                    defensePers.hp -= attackPers.attack * 2;
                    whatPrint = 1;
                } else if (isAttack) defensePers.hp -= attackPers.attack;
                else whatPrint = 3;
            }
            if (defensePers.hp > 0) {
                switch (whatPrint) {
                    case 1 -> System.out.println(attackPers.name + " подловил момент и нанес сокрушительный удар " + defensePers.name);
                    case 2 -> System.out.println(attackPers.name + " бьет и у " + defensePers.name + " осталось " + defensePers.hp);
                    case 3 -> System.out.println(attackPers.name + " допускает обидный промах и не наносит никакого урона " + defensePers.name);
                }
            } else {
                System.out.println(attackPers.name + " бьет и побеждает " + defensePers.name);
                break;
            }

            whatPrint = 2;
            if (defensePers.level > attackPers.level + 3) attackPers.hp -= defensePers.attack * 2;
            else if (defensePers.level + 3 < attackPers.level) attackPers.hp -= defensePers.attack / 2;
            else {
                rand = (int) (Math.random() * 100 + 1);
                isAttack = defensePers.dexterity * 3 > rand;
                if (isAttack && rand >= 93) {
                    attackPers.hp -= defensePers.attack * 2;
                    whatPrint = 1;
                } else if (isAttack) attackPers.hp -= defensePers.attack;
                else whatPrint = 3;
            }
            if (attackPers.hp > 0) {
                switch (whatPrint) {
                    case 1 -> System.out.println(defensePers.name + " подловил момент и нанес сокрушительный удар " + attackPers.name);
                    case 2 -> System.out.println(defensePers.name + " бьет и у " + attackPers.name + " осталось " + attackPers.hp);
                    case 3 -> System.out.println(defensePers.name + " допускает обидный промах и не наносит никакого урона " + attackPers.name);
                }
            } else {
                System.out.println(defensePers.name + " бьет и побеждает " + attackPers.name);
                break;
            }

            moveCount++;
            GameMenu.Assist.pause(1000);
        }
//            –асконсервируй дл€ запуска атаки в отдельном потоке
/*        };
//        Thread thread = new Thread(runnable);
          thread.start();*/

/*            ≈сли персонаж игрока проиграл в битве, то у него отнимаетс€ 1 жизнь,
              и уровень здоровь€ восполн€етс€ до уровн€ здоровь€ соответствующего
              уровню персонажа*/
        if (hero.hp <= 0) {
            ((Players) hero).lives--;
            if (((Players) hero).lives > 0) {
                System.out.println("¬ы потратили жизнь, осталось еще " + ((Players) hero).lives);
                hero.hp = ((Players) hero).cloneHP;
            } else if (((Players) hero).lives == 0) {
                System.out.println("Ёта жизнь последн€€, будьте внимательны");
                hero.hp = ((Players) hero).cloneHP;
            } else ((Players) hero).lives = -1;
//             ¬ случае победы персонажа игрока - он набирает опыт и забирает золото монстра
        } else {
            hero.exp += monster.exp;
            hero.gold += monster.gold;
            System.out.println(hero.name + " набрал " + monster.exp + " опыта, и затрофеил  " + monster.gold + " золотишка!");
            ((Players) hero).levelUp();
        }
    }

    //     ѕросмотр характеристик персонажа
    void print(BattlePersonage pers) {
        System.out.println("’арактеристики: " + pers.name);
        System.out.println("”ровень - " + pers.level);
        System.out.println("«доровье - " + pers.hp);
        System.out.println("—ила - " + pers.strength);
        System.out.println("Ћовкость - " + pers.dexterity);
    }
}
