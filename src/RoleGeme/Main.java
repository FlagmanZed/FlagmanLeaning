package RoleGeme;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("��� ��������� ������� ������ � ������� ��� ����, � ���� ������ ����");
        System.out.println("��� �������� ���� - ������� ��� ������ ���������:");
        String heroName = scan.nextLine();

        Players hero = new Human(heroName);
        GameScene game = new GameScene(hero);
        hero.print(hero);
        System.out.println("����, �� ������� � ����� N.....");

        game.mainTownScene();

    }
}
