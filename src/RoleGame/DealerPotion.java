package RoleGame;

// ����� �������� �������
public class DealerPotion extends Npc {
    Backpak potionPack;

    DealerPotion(String name) {
        super(name);
        potionPack = new Backpak();
        for (int i = 0; i < potionPack.inventory.length; i++) {
            potionPack.inventory[i] = new Potion();
        }
    }

    //    �������� ������������ ��������
    void showProduct() {
        StringBuilder tmp = new StringBuilder();
        int k = 1;
        for (int i = 0; i < potionPack.inventory.length; i++) {
            tmp.append(k++).append(". ").append(potionPack.inventory[i].name).append(" ").append(potionPack.inventory[i].level).append(" �������").append(" - ").append(potionPack.inventory[i].price).append(" �������\n");
        }
        System.out.println("�������� ���������� �� �������:\n" + tmp);
    }

    //    ������� ����� � ��������
    void sellProduct(Players hero) {
        Items item = potionPack.changeItem();
        if (hero.gold > item.price) {
            potionPack.drop(item);
            hero.backpak.take(item);
            hero.gold -= item.price;
            System.out.println("�� ������ " + item.name);
        } else System.out.println("��� ������� ������ ��� ���");
    }
}

