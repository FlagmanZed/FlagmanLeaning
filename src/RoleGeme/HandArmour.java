package RoleGeme;

public class HandArmour extends Armour {

    HandArmour() {
        typeMarker = "handsArm";
        if (level == 1) {
            name = "Кожаные наручи";
            defense = 10;
        } else if (level == 2) {
            name = "Кольчужные перчатки";
            defense = 20;
        } else {
            name = "Латный рукав";
            defense = 30;
        }
    }

    HandArmour(String name) {
        this.name = name;
        defense=0;
    }
}
