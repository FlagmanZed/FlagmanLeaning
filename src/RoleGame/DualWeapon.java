package RoleGame;

public class DualWeapon extends Weapon {

    DualWeapon() {
        typeMarker = "dualHandWep";
        if (level == 1) {
            name = "����";
            power = 15;
        } else if (level == 2) {
            name = "������";
            power = 25;
        } else if (level == 3) {
            name = "�����";
            power = 35;
        } else if (level == 4) {
            name = "����";
            power = 45;
        } else if (level == 5) {
            name = "�������";
            power = 55;
        } else if (level == 6) {
            name = "����������";
            power = 65;
        } else if (level == 7) {
            name = "������";
            power = 75;
        } else if (level == 8) {
            name = "�����";
            power = 85;
        } else if (level == 9) {
            name = "������ ��������";
            power = 110;
        } else {
            name = "��������";
            power = 130;
        }
    }
}
