package RoleGeme;



public class Goblin extends Monsters {

    Goblin(String name) {
        super(name);
        hp = 40 + 15 * level;
        strength = 15 + 5 * level;
        dexterity = 5 + 5 * level;
        exp = (hp + strength + dexterity) / 2;
        attack = strength;
    }
}