package RoleGeme;

public class Backpak extends Equipment implements UsableInventory {

    protected Items[] inventory = new Items[5];

//    �������� ������ ����� �������� ������� � ������
    @Override
    public void take(Items item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                System.out.println("�� �������� " + item.name + " � ������");
                System.out.println();
                break;
            } else continue;
        }
        if (isFull()) {
            System.out.println("������ �����");
            System.out.println();
        }
    }

//    �������� ������������� �������
    boolean isFull() {
        int tmp = 0;
        for (Items items : inventory) {
            if (items != null) tmp++;
        }
        return tmp == inventory.length;
    }

//    ��������� ��������� ������� �� �������
    @Override
    public void drop(Items item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) continue;
            else {
                if (inventory[i].name.equals(item.name)) {
//                    System.out.println("������� " + inventory[i].name + " ��������");
                    inventory[i] = null;
                    break;
                }
            }
        }
    }

// ��������� �� ������� ��������� ������� � �������� ������ ���� ������
    @Override
    public void exchange(Items find, Items drop) {
        drop(drop);
        take(find);
    }

//    ��������� ���������� �������
    @Override
    public String show() {
        StringBuilder tmp = new StringBuilder();
        int k = 1;
        for (Items items : inventory) {
            if (items != null) {
                tmp.append(k++).append(". ").append(items.name).append(" ").append(items.level).append(" �������\n");
            }
        }
        if (tmp.toString().equals("")) return "nothing";
        else return "� ������� �����:\n" + tmp;
    }

//    ������� ������ ������� � �������
    Items changeItem() {
        int tmp = 0;
        Items item = null;
        System.out.println("������� ����� ��������:");
        for (Items value : inventory) {
            if (value != null) tmp++;
        }
        int command = GameMenu.Assist.makeRightChoice(1, tmp);
        int k = 0;
        for (Items items : inventory) {
            if (items == null) continue;
            else {
                k++;
                if (command == k) {
                    item = items;
                    break;
                }
            }
        }
        System.out.println("������ " + item.name);
        return item;
    }
}