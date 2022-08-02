package RoleGame;
/*  Это абстрактный класс для всех персонажей в игре
*/


public abstract class Personage {

    protected String name;
    protected int gold;

    Personage(String name) {
        this.name = name;
    }
}
