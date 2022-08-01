package RoleGeme;

public class DealerPotion extends Npc {
    Backpak potionPack;

    DealerPotion(String name) {
        super(name);
        potionPack = new Backpak();
        for (int i = 0; i < potionPack.inventory.length; i++) {
            potionPack.inventory[i] = new Potion();
        }
    }

    void showProduct() {
        String tmp = "";
        int k = 1;
        for (int i = 0; i < potionPack.inventory.length; i++) {
            tmp += (k++ + ". " + potionPack.inventory[i].name + " " + potionPack.inventory[i].level + " уровень" + " - " + potionPack.inventory[i].price + " золотых\n");
        }
        System.out.println("“орговец предлагает на продажу:\n" + tmp);
    }

    void sellProduct(Players hero) {
        Items item = potionPack.changeItem();
        if (hero.gold > item.price) {
            potionPack.drop(item);
            hero.backpak.take(item);
            System.out.println("¬ы купили " + item.name);
        } else System.out.println("Ёто слишком дорого дл€ вас");
    }
}

