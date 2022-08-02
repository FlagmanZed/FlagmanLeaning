package RoleGame;

public class Dragon extends Monsters{

    Dragon(String name) {
        super(name);
        hp = 150 + 50 * level;
        strength = 55 + 60 * level;
        dexterity = 40 + 15 * level;
        exp = (hp + strength + dexterity) / 2;
        attack = strength;
    }
}
