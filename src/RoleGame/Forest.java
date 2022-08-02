package RoleGame;

public class Forest extends Location {

    Forest() {
        int percent = (int) (Math.random() * 100 + 1);
        if (percent > 0 && percent <= 50) monster = new Ork("Forest Ork");
        else monster = new WereWolf("Werewolf");
        this.name = "========าลฬอÛษ หลั========";
    }

}
