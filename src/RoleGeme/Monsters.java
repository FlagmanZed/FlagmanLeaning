package RoleGeme;

/* ����� ��� �������� ��������
   ������ ����� ������ ����� ���������� ������ �� 1 �� 10
   � ����� ��������� ���������� ������
 */

public class Monsters extends BattlePersonage {

    public Monsters(String name) {
        super(name);
        level = (int) (Math.random() * 10 + 1);
        gold = (int) Math.ceil(Math.random() * 20 * level);
    }

}