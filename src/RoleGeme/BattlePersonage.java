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
            System.out.println(monster.name + " �������� �������" + hero.name + " � ������� ���� ������");
            attackPers = monster;
            defensePers = hero;
        } else {
            System.out.println(hero.name + " ��������� ��������� � " + monster.name + " � ������� ���� ������");
            attackPers = hero;
            defensePers = monster;
        }
        while (attackPers.hp > 0 && defensePers.hp > 0) {
            System.out.println("=== ��� " + moveCount + " ===");
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
                System.out.println(attackPers.name + " ���� � � " + defensePers.name + " �������� " + defensePers.hp);
                System.out.println(defensePers.name + " ���� � � " + attackPers.name + " �������� " + attackPers.hp);
            } else if (defensePers.hp > 0 && attackPers.hp <= 0)
                System.out.println(defensePers.name + " ���� � ��������� " + attackPers.name);
            else System.out.println(attackPers.name + " ���� � ��������� " + defensePers.name);

            moveCount++;
            GameMenu.Choice.pause(1000);
        }
        if (hero.hp <= 0) {
            ((Players) hero).lives--;
            System.out.println("�� ��������� �����, �������� ��� " + ((Players) hero).lives);
            ((Players) hero).hp = ((Players) hero).cloneHP;
        } else {
            ((Players) hero).exp += ((Monsters) monster).exp;
            ((Players) hero).gold += ((Monsters) monster).gold;
            System.out.println(((Players) hero).name + " ������ " + ((Monsters) monster).exp + " �����, � ���������  " + ((Monsters) monster).gold + " ���������!");
            ((Players) hero).levelUp();
        }
    }

    void print(BattlePersonage pers) {
        System.out.println("��������������: " + pers.name);
        System.out.println("������� - " + pers.level);
        System.out.println("�������� - " + pers.hp);
        System.out.println("���� - " + pers.strength);
        System.out.println("�������� - " + pers.dexterity);
    }
}
