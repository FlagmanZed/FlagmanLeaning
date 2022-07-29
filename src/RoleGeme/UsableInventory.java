package RoleGeme;

public interface UsableInventory {

    void take(Items item);

    void drop(Items item);

    void find(Items item, int index);

    String show();
}
