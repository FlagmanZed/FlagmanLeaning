package RoleGame;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class GameMenu {

    static void mainTownMenu(){
        System.out.println("""
                    =======ГОРОД=======
                Введите необходимую команду:
                'Характеристики героя'   - 1
                'Идти домой, спать'      - 2
                'Идти к торговцу'        - 3
                'Идти в горы'            - 4
                'Идти в лес'             - 5
                'Идти на болота'         - 6
                'Идти в подземелья'      - 7
                'Уйти на пенсию'         - 8
                'Инвентарь'              - 0""");
    }

    static void locationMenu(){
        System.out.println("""
                Что будете делать?:
                'Характеристики героя'   - 1
                'Характеристики монстра' - 2
                'Атаковать монстра'      - 3
                'Осмотреть территорию'   - 4
                'Идти дальше'            - 5
                'Вернуться в город'      - 6
                'Инвентарь'              - 0""");
    }

    static void inventoryMenuChoice(){
        System.out.println("""
                Что хотите сделать?:
                'Выбрать предмет'        - 1
                'Назад'                  - 0""");
    }

    static void inventoryMenuUse(){
        System.out.println("""
                Что хотите сделать?:
                'Использовать предмет'   - 1
                'Выбросить предмет'      - 2
                'Назад'                  - 0""");
    }

    static void takeMenu(){
        System.out.println("""
                Что хотите сделать?:
                'Использовать'          - 1
                'Положить в рюкзак'     - 2
                'Ничего не делать       - 0""");
        System.out.println();
    }

    static void exchangeMenu(){
        System.out.println("""
                Что хотите сделать?:
                'Освободить место       - 1
                'Ничего не делать       - 0""");
        System.out.println();
    }

    static void sellMenu(){
        System.out.println("""
                Что хотите сделать?:
                'Купить предмет         - 1
                'Ничего не делать       - 0""");
        System.out.println();
    }

    static void gameOver(){
        System.out.println();
        System.out.println("Бесславному вояке  - бесславный конец....");
        System.out.println("Ваша миссия завершилась провалом");
    }

    static class Assist {

        static int makeRightChoice(int indexDown, int indexUp) {
            int tmp = -1;
            while (tmp == -1) {
                try {
                    tmp = new Scanner(System.in).nextInt();
                } catch (Exception e) {
                    System.out.println("Вы ввели не цифру, попробуйте ещё раз");
                    tmp = -1;
                }
                if (tmp < indexDown || tmp > indexUp) {
                    System.out.println("Введите цифру из списка");
                    tmp = -1;
                }
            }
            return tmp;
        }
       static void pause(int milSec) {
            try {
                sleep(milSec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
