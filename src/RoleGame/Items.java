package RoleGame;

public abstract class Items {

    protected String name, classMarker, typeMarker;
    protected int level, price;

    Items() {
        int percent = (int) (Math.random() * 100 + 1);
        if (percent > 0 && percent <= 75) level = (int) (Math.random() * 5 + 1);
        else if (percent > 75 && percent < 95) level = (int) (Math.random() * 3 + 6);
        else level = (int) (Math.random() * 2 + 9);

    }
}