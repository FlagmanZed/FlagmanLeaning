package RoleGeme;

public class MutantRat extends Monsters{

    MutantRat(String name) {
        super(name);
        hp = 30 + 10 * level;
        strength = 5 * level;
        dexterity = 5 * level;
        exp = (hp + strength + dexterity) / 2;
        attack = strength;
    }
}
