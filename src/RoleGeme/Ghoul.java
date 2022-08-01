package RoleGeme;

public class Ghoul extends Monsters{

    Ghoul(String name) {
        super(name);
        hp = 35 + 5 * level;
        strength = 20 + 5 * level;
        dexterity = 5 + 5 * level;
        exp = (hp + strength + dexterity) / 2;
        attack = strength;
    }
}
