package RoleGeme;

public class WereWolf extends Monsters {

    WereWolf(String name) {
        super(name);
        hp = 50 + 10 * level;
        strength = 15 + 5 * level;
        dexterity = 10 + 5 * level;
        exp = (hp + strength + dexterity) / 2;
        attack = strength;
    }
}
