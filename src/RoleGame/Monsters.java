package RoleGame;

/* ����� ��� �������� ��������
   ������ ����� ������ ����� ���������� ������ �� 1 �� 10
   � ����� ��������� ���������� ������
 */

public abstract class Monsters extends BattlePersonage {

    public Monsters(String name) {
        super(name);
        level = (int) (Math.random() * 10 + 1);
        gold = (int) Math.ceil(Math.random() * 20 * level);
    }

}
