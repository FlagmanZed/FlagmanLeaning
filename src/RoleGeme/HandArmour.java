package RoleGeme;

public class HandArmour extends Armour {

    HandArmour() {
        typeMarker = "handsArm";
        if (level == 1) {
            name = "������� ������";
            defense = 10;
        } else if (level == 2) {
            name = "���������� ��������";
            defense = 20;
        } else {
            name = "������ �����";
            defense = 30;
        }
    }

    HandArmour(String name) {
        this.name = name;
        defense=0;
    }
}
