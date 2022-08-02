package RoleGame;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class GameMenu {

    static void mainTownMenu(){
        System.out.println("""
                    =======�����=======
                ������� ����������� �������:
                '�������������� �����'   - 1
                '���� �����, �����'      - 2
                '���� � ��������'        - 3
                '���� � ����'            - 4
                '���� � ���'             - 5
                '���� �� ������'         - 6
                '���� � ����������'      - 7
                '���� �� ������'         - 8
                '���������'              - 0""");
    }

    static void locationMenu(){
        System.out.println("""
                ��� ������ ������?:
                '�������������� �����'   - 1
                '�������������� �������' - 2
                '��������� �������'      - 3
                '��������� ����������'   - 4
                '���� ������'            - 5
                '��������� � �����'      - 6
                '���������'              - 0""");
    }

    static void inventoryMenuChoice(){
        System.out.println("""
                ��� ������ �������?:
                '������� �������'        - 1
                '�����'                  - 0""");
    }

    static void inventoryMenuUse(){
        System.out.println("""
                ��� ������ �������?:
                '������������ �������'   - 1
                '��������� �������'      - 2
                '�����'                  - 0""");
    }

    static void takeMenu(){
        System.out.println("""
                ��� ������ �������?:
                '������������'          - 1
                '�������� � ������'     - 2
                '������ �� ������       - 0""");
        System.out.println();
    }

    static void exchangeMenu(){
        System.out.println("""
                ��� ������ �������?:
                '���������� �����       - 1
                '������ �� ������       - 0""");
        System.out.println();
    }

    static void sellMenu(){
        System.out.println("""
                ��� ������ �������?:
                '������ �������         - 1
                '������ �� ������       - 0""");
        System.out.println();
    }

    static void gameOver(){
        System.out.println();
        System.out.println("����������� �����  - ���������� �����....");
        System.out.println("���� ������ ����������� ��������");
    }

    static class Assist {

        static int makeRightChoice(int indexDown, int indexUp) {
            int tmp = -1;
            while (tmp == -1) {
                try {
                    tmp = new Scanner(System.in).nextInt();
                } catch (Exception e) {
                    System.out.println("�� ����� �� �����, ���������� ��� ���");
                    tmp = -1;
                }
                if (tmp < indexDown || tmp > indexUp) {
                    System.out.println("������� ����� �� ������");
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
