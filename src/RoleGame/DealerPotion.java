package RoleGame;

// Класс торговца зельями
public class DealerPotion extends Npc {
    Backpak potionPack;

    DealerPotion(String name) {
        super(name);
        potionPack = new Backpak();
        for (int i = 0; i < potionPack.inventory.length; i++) {
            potionPack.inventory[i] = new Potion();
        }
    }

    //    Просмотр ассортимента торговца
    void showProduct() {
        StringBuilder tmp = new StringBuilder();
        int k = 1;
        for (int i = 0; i < potionPack.inventory.length; i++) {
            tmp.append(k++).append(". ").append(potionPack.inventory[i].name).append(" ").append(potionPack.inventory[i].level).append(" уровень").append(" - ").append(potionPack.inventory[i].price).append(" золотых\n");
        }
        System.out.println("Торговец предлагает на продажу:\n" + tmp);
    }

    //    Продажа зелий у торговца
    void sellProduct(Players hero) {
        Items item = potionPack.changeItem();
        if (hero.gold > item.price) {
            potionPack.drop(item);
            hero.backpak.take(item);
            hero.gold -= item.price;
            System.out.println("Вы купили " + item.name);
        } else System.out.println("Это слишком дорого для вас");
    }
}

