package RoleGame;

public class OneWeapon extends Weapon {


    OneWeapon() {
        typeMarker = "oneHandWep";
        if (level == 1) {
            name = "������� ���";
            power = 5;
        } else if (level == 2) {
            name = "������";
            power = 10;
        } else if (level == 3) {
            name = "�����";
            power = 15;
        } else if (level == 4) {
            name = "������";
            power = 20;
        } else if (level == 5) {
            name = "�������";
            power = 25;
        } else if (level == 6) {
            name = "��������� ���";
            power = 30;
        } else if (level == 7) {
            name = "������";
            power = 35;
        } else if (level == 8) {
            name = "��������";
            power = 40;
        } else if (level == 9) {
            name = "�����������";
            power = 50;
        } else {
            name = "��������";
            power = 60;
        }
    }

    OneWeapon(String name) {
        this.name = name;
        typeMarker = "oneHandWep";
        this.power = 0;
    }
}
