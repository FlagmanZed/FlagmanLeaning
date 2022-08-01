package RoleGeme;

public interface UsableInventory {

    void take(Items item);

    void drop(Items item);

    void exchange(Items find, Items drop);

    String show();
}
