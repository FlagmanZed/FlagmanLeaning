package RoleGame;

public class DualWeapon extends Weapon {

    DualWeapon() {
        typeMarker = "dualHandWep";
        if (level == 1) {
            name = "Шест";
            power = 15;
        } else if (level == 2) {
            name = "Дубина";
            power = 25;
        } else if (level == 3) {
            name = "Копье";
            power = 35;
        } else if (level == 4) {
            name = "Пика";
            power = 45;
        } else if (level == 5) {
            name = "Клеймор";
            power = 55;
        } else if (level == 6) {
            name = "Цвайхандер";
            power = 65;
        } else if (level == 7) {
            name = "Секира";
            power = 75;
        } else if (level == 8) {
            name = "Молот";
            power = 85;
        } else if (level == 9) {
            name = "Боевой трезубец";
            power = 110;
        } else {
            name = "Алебарда";
            power = 130;
        }
    }
}
