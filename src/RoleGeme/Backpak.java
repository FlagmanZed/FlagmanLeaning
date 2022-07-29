package RoleGeme;

public class Backpak extends Equipment implements UsableInventory {

    Items[] inventory = new Items[5];

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
        if (isEmpty()) {
            System.out.println("������ �����");
            System.out.println();
        }
    }

    boolean isEmpty() {
        int tmp = 0;
        for (Items items : inventory) {
            if (items != null) tmp++;
        }
        return tmp == inventory.length;
    }

    @Override
    public void drop(Items item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) continue;
            else {
                if (inventory[i].name.equals(item.name)) {
                    System.out.println("������� " + inventory[i].name + " ��������");
                    inventory[i] = null;
                    break;
                }
            }
        }
    }

    @Override
    public void find(Items item, int index) {
        drop(item);
        take(item);
    }

    @Override
    public String show() {
        String tmp = "";
        int k = 1;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                tmp += (k++ + ". " + inventory[i].name + " " + inventory[i].level + " �������\n");
            }
        }
        if (tmp.equals("")) return "nothing";
        else return "� ������� �����:\n" + tmp;
    }

    Items changeItem() {
        int tmp = 0;
        Items item = null;
        System.out.println("������� ����� ��������:");
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) tmp++;
        }
        int command = GameMenu.Choice.makeRightChoice(1, tmp);
        int k = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) continue;
            else {
                k++;
                if (command == k) {
                    item = inventory[i];
                    break;
                }
            }
        }
        System.out.println("������ " + item.name);
        return item;
    }
}