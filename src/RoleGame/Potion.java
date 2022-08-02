package RoleGame;

public class Potion extends Items {

    protected int recoveryHP;

    Potion() {
        classMarker = "all";
        typeMarker = "potionHP";
        price = 10 * (int) Math.pow(level, 2);
        if (level == 1) {
            name = "Капля зелья";
            recoveryHP = 10;
        } else if (level == 2) {
            name = "Пара капель зелья";
            recoveryHP = 20;
        } else if (level == 3) {
            name = "Пять капель зелья";
            recoveryHP = 50;
        } else if (level == 4) {
            name = "Пробник с зельем";
            recoveryHP = 100;
        } else if (level == 5) {
            name = "Маленький пузырек с зельем";
            recoveryHP = 150;
        } else if (level == 6) {
            name = "Пузырек с зельем";
            recoveryHP = 225;
        } else if (level == 7) {
            name = "Большой пузырек с зельем";
            recoveryHP = 300;
        } else if (level == 8) {
            name = "Маленький флакон зелья";
            recoveryHP = 400;
        } else if (level == 9) {
            name = "Большой флакон зелья";
            recoveryHP = 500;
        } else {
            name = "Эликсир жизни";
            recoveryHP = 10000;
        }
    }
}
