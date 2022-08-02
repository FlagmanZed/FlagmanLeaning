package RoleGeme;

public class Backpak extends Equipment implements UsableInventory {

    protected Items[] inventory = new Items[5];

//    Персонаж игрока может положить предмет в рюкзак
    @Override
    public void take(Items item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                System.out.println("Вы положили " + item.name + " в рюкзак");
                System.out.println();
                break;
            } else continue;
        }
        if (isFull()) {
            System.out.println("Рюкзак полон");
            System.out.println();
        }
    }

//    Проверка заполненности рюкзака
    boolean isFull() {
        int tmp = 0;
        for (Items items : inventory) {
            if (items != null) tmp++;
        }
        return tmp == inventory.length;
    }

//    выбросить выбранный предмет из рюкзака
    @Override
    public void drop(Items item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) continue;
            else {
                if (inventory[i].name.equals(item.name)) {
//                    System.out.println("Предмет " + inventory[i].name + " выброшен");
                    inventory[i] = null;
                    break;
                }
            }
        }
    }

// Выбросить из рюкзака выбранный предмет и положить вместо него другой
    @Override
    public void exchange(Items find, Items drop) {
        drop(drop);
        take(find);
    }

//    Помотреть содержимое рюкзака
    @Override
    public String show() {
        StringBuilder tmp = new StringBuilder();
        int k = 1;
        for (Items items : inventory) {
            if (items != null) {
                tmp.append(k++).append(". ").append(items.name).append(" ").append(items.level).append(" уровень\n");
            }
        }
        if (tmp.toString().equals("")) return "nothing";
        else return "В рюкзаке лежит:\n" + tmp;
    }

//    Выбрать нужный предмет в рюкзаке
    Items changeItem() {
        int tmp = 0;
        Items item = null;
        System.out.println("Введите номер предмета:");
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
        System.out.println("Выбран " + item.name);
        return item;
    }
}