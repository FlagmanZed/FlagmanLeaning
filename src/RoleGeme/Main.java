package RoleGeme;

public class Main {

    public static void main(String[] args) {
        Players pers1 = new Human("Arni");
        GameScene game= new GameScene(pers1);
        Weapon wep = new OneWeapon();
        Weapon wep2 = new DualWeapon();
        Weapon wep3 = new OneWeapon();
        Weapon wep4 = new DualWeapon();
//        pers1.use(wep2);
        pers1.backpak.take(wep);
        pers1.backpak.take(wep2);
        pers1.backpak.take(wep3);
        pers1.backpak.take(wep4);

        game.mainTownScene();



    }
}
