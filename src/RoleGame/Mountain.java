package RoleGame;

public class Mountain extends Location{

    Mountain() {
        int percent = (int) (Math.random() * 100 + 1);
        if (percent > 0 && percent <= 50) monster = new Troll("Mountain Troll");
        else monster = new Dragon("Cave Dragon");
        this.name="======ÑÊÀËÈÑÒÛÅ ÃÎÐÛ======";
    }
}
