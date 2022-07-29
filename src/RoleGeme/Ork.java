package RoleGeme;


public class Ork extends Monsters {

    Ork(String name) {
        super(name);
        hp = 40 + 20 * level;
        strength = 30 + 5 * level;
        dexterity = 10 + 5 * level;
        exp = (hp + strength + dexterity) / 2;
        attack = strength;
        System.out.println(attack);
    }
}
