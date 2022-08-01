package RoleGeme;

/* Класс для создания монстров
   каждый новый монстр будет случайного уровня от 1 до 10
   и иметь некоторое количество золота
 */

public class Monsters extends BattlePersonage {

    public Monsters(String name) {
        super(name);
        level = (int) (Math.random() * 10 + 1);
        gold = (int) Math.ceil(Math.random() * 20 * level);
    }

}
