package RoleGame;

public class Potion extends Items {

    protected int recoveryHP;

    Potion() {
        classMarker = "all";
        typeMarker = "potionHP";
        price = 10 * (int) Math.pow(level, 2);
        if (level == 1) {
            name = "����� �����";
            recoveryHP = 10;
        } else if (level == 2) {
            name = "���� ������ �����";
            recoveryHP = 20;
        } else if (level == 3) {
            name = "���� ������ �����";
            recoveryHP = 50;
        } else if (level == 4) {
            name = "������� � ������";
            recoveryHP = 100;
        } else if (level == 5) {
            name = "��������� ������� � ������";
            recoveryHP = 150;
        } else if (level == 6) {
            name = "������� � ������";
            recoveryHP = 225;
        } else if (level == 7) {
            name = "������� ������� � ������";
            recoveryHP = 300;
        } else if (level == 8) {
            name = "��������� ������ �����";
            recoveryHP = 400;
        } else if (level == 9) {
            name = "������� ������ �����";
            recoveryHP = 500;
        } else {
            name = "������� �����";
            recoveryHP = 10000;
        }
    }
}
