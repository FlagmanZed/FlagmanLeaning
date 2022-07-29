package RoleGeme;

public class Human extends Players {

    Human(String name) {
        super(name);
        classMarker = "physic";
        strength = 10;
        dexterity = 10;
        hp = cloneHP = 100;
        attack = strength;
        defense = dexterity;
    }
}