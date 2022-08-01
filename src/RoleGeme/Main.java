package RoleGeme;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Эта микроигра покажет почему у самурая нет цели, а есть только путь");
        System.out.println("Для познания сего - введите имя вашего персонажа:");
        String heroName = scan.nextLine();

        Players hero = new Human(heroName);
        GameScene game = new GameScene(hero);
        hero.print(hero);
        System.out.println("Итак, вы прибыли в город N.....");

        game.mainTownScene();

    }
}
