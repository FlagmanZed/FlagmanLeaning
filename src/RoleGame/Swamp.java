package RoleGame;

public class Swamp extends Location {

    Swamp() {
        int percent = (int) (Math.random() * 100 + 1);
        if (percent > 0 && percent <= 50) monster = new Goblin("Swamp Goblin");
        else monster = new Ghoul("Lousy Ghoul");
        this.name="======ÂÎÍÞ×ÅÅ ÁÎËÎÒÎ======";

    }
}
