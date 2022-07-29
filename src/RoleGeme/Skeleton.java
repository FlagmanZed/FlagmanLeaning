package RoleGeme;



public class Skeleton extends Monsters {

    public Skeleton(String name) {
        super(name);
        hp = 40 + 10 * level;
        strength = 5 + 5 * level;
        dexterity = 10;
        exp = (hp + strength + dexterity) / 2;
        attack = strength;
    }
}
