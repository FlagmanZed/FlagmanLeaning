package RoleGeme;
/*  ��� ����� ��� ���� ����������, ������� �����
    ��������� ������� � �������.
    � �������� ��� ������ - ����� � ����� �������������
*/

public class BattlePersonage extends Personage implements Attacking {

    protected String classMarker;
    protected int strength, dexterity;
    protected int hp, attack, defense;
    protected int level, exp;

    BattlePersonage(String name) {
        super(name);
    }

    @Override
    public void attack(BattlePersonage hero, BattlePersonage monster) {
        //���������� ���������� � �������������
        BattlePersonage attackPers;
        BattlePersonage defensePers;
        int moveCount = 1;
        //� ������������ 90% ���������� ����� �������� ������
        if ((int) (Math.random() * 100 + 1) <= 10) {
            System.out.println(monster.name + " �������� ������� " + hero.name + " � ������� ���� ������");
            attackPers = monster;
            defensePers = hero;
        } else {
            System.out.println(hero.name + " ��������� ��������� � " + monster.name + " � ������� ���� ������");
            attackPers = hero;
            defensePers = monster;
        }
        /*  ��������� ���� ������������ ��������� ������. ������ ���� ���������.
            � ������, ���� ������� ������ �� ���������� ����� �� 3 ������ �������
            �� ���� �������� ������� ������� ����, � ������� ���� � ��� ���� ������*/
        while (attackPers.hp > 0 && defensePers.hp > 0) {
            System.out.println("=== ��� " + moveCount + " ===");
            if (attackPers.level > defensePers.level + 3) defensePers.hp -= (attackPers.attack * 2);
            else if (defensePers.level > attackPers.level + 3) defensePers.hp -= (attackPers.attack / 2);
            else defensePers.hp -= attackPers.attack;
            if (defensePers.hp > 0) {
                System.out.println(attackPers.name + " ���� � � " + defensePers.name + " �������� " + defensePers.hp);
            } else {
                System.out.println(attackPers.name + " ���� � ��������� " + defensePers.name);
                break;
            }

            if (defensePers.level > attackPers.level + 3) attackPers.hp -= (defensePers.attack * 2);
            else if (defensePers.level < attackPers.level + 3) attackPers.hp -= (defensePers.attack / 2);
            else attackPers.hp -= defensePers.attack;
            if (attackPers.hp > 0) {
                System.out.println(defensePers.name + " ���� � � " + attackPers.name + " �������� " + attackPers.hp);
            } else {
                System.out.println(defensePers.name + " ���� � ��������� " + attackPers.name);
                break;
            }

            moveCount++;
            GameMenu.Assist.pause(1000);
        }
        /* ���� �������� ������ �������� � �����, �� � ���� ���������� 1 �����,
            � ������� �������� ������������ �� ������ �������� ����������������
            ������ ��������� */
        if (hero.hp <= 0) {
            ((Players) hero).lives--;
            if (((Players) hero).lives > 0) {
                System.out.println("�� ��������� �����, �������� ��� " + ((Players) hero).lives);
                hero.hp = ((Players) hero).cloneHP;
            } else if (((Players) hero).lives == 0) {
                System.out.println("��� ����� ���������, ������ �����������");
                hero.hp = ((Players) hero).cloneHP;
            } else ((Players) hero).lives = -1;
            // � ������ ������ ��������� ������ - �� �������� ���� � �������� ������ �������
        } else {
            hero.exp += monster.exp;
            hero.gold += monster.gold;
            System.out.println(hero.name + " ������ " + monster.exp + " �����, � ���������  " + monster.gold + " ���������!");
            ((Players) hero).levelUp();
        }
    }

    // �������� ������������� ���������
    void print(BattlePersonage pers) {
        System.out.println("��������������: " + pers.name);
        System.out.println("������� - " + pers.level);
        System.out.println("�������� - " + pers.hp);
        System.out.println("���� - " + pers.strength);
        System.out.println("�������� - " + pers.dexterity);
    }
}
