package RoleGame;

public class OneWeapon extends Weapon {


    OneWeapon() {
        typeMarker = "oneHandWep";
        if (level == 1) {
            name = "Финский нож";
            power = 5;
        } else if (level == 2) {
            name = "Кинжал";
            power = 10;
        } else if (level == 3) {
            name = "Топор";
            power = 15;
        } else if (level == 4) {
            name = "Мачете";
            power = 20;
        } else if (level == 5) {
            name = "Гладиус";
            power = 25;
        } else if (level == 6) {
            name = "Кельтский меч";
            power = 30;
        } else if (level == 7) {
            name = "Клевец";
            power = 35;
        } else if (level == 8) {
            name = "Фальчион";
            power = 40;
        } else if (level == 9) {
            name = "Моргенштерн";
            power = 50;
        } else {
            name = "Шестопер";
            power = 60;
        }
    }

    OneWeapon(String name) {
        this.name = name;
        typeMarker = "oneHandWep";
        this.power = 0;
    }
}
