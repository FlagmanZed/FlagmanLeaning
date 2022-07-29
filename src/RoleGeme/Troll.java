package RoleGeme;



public class Troll extends Monsters {

    Troll(String name) {
        super(name);
        hp = 40 + 40 * level;
        strength = 50 + 5 * level;
        dexterity = 5;
        exp = (hp + strength + dexterity) / 2;
        attack = strength;
    }
}