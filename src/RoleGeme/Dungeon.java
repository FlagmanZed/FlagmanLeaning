package RoleGeme;

public class Dungeon extends Location {

    Dungeon() {
        int percent = (int) (Math.random() * 100 + 1);
        if (percent > 0 && percent <= 50) monster = new Skeleton("Evil Skeleton");
        else monster = new MutantRat("Mutant Rat");
        this.name="======ÑÛÐÎÅ ÏÎÄÇÅÌÅËÜÅ======";
    }
}
