package Cipher;

import java.util.Arrays;
import java.util.Scanner;

public class Text {

    private int[] arrSumWords, arrSumChar;
    private boolean isStop;

    // преобразуем текст в массивы
    void codeText(String message) {
        String[] text = message.trim().split(" ");
        arrSumWords = new int[text.length];
        int ch = 0, w = 0, wrdlgth = 0;
        for (String tm : text) {
            arrSumWords[w] = tm.length();
            ch += tm.length();
            w++;
        }
        arrSumChar = new int[ch];
        for (String wrd : text) {
            for (int i = 0; i < wrd.length(); i++) {
                arrSumChar[i + wrdlgth] = wrd.charAt(i);
            }
            wrdlgth += wrd.length();
        }
    }

    // преобразуем массив в текст
    String printText(int[] arrSumWords, int[] arrSumChar) {
        StringBuilder s = new StringBuilder();
        for (int k : arrSumChar) {
            char str = (char) k;
            s.append(str);
        }
        int j = 0;
        StringBuilder tmp = new StringBuilder();
        for (int a : arrSumWords) {
            String tmp1 = s.substring(j, j + a);
            tmp.append(tmp1).append(" ");
            j += a;
        }
        return tmp.toString().trim();
    }

    // преобразуем массив в текст
    int[] convers(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
        return arr;
    }

    void ciphText(String txtForCiph) {
        codeText(txtForCiph);
        for (int i = 0; i < arrSumChar.length; i++) {
            arrSumChar[i] = arrSumChar[i] * 2 - arrSumChar.length + i;
        }
        arrSumWords = convers(arrSumWords);
        System.out.println(printText(arrSumWords, arrSumChar));
        System.out.println(Arrays.toString(arrSumChar));
        System.out.println(Arrays.toString(arrSumWords));
    }

    void deciphText(String txtForDeciph) {
        codeText(txtForDeciph);
        for (int i = 0; i < arrSumChar.length; i++) {
            arrSumChar[i] = (arrSumChar[i] + arrSumChar.length - i) / 2;
        }
        arrSumWords = convers(arrSumWords);
        System.out.println(printText(arrSumWords, arrSumChar));
    }

    void work() {
        isStop = false;
        String message = "";
        Scanner scan = new Scanner(System.in);
        Scanner mess = new Scanner(System.in);
        System.out.println("""
                        Выберите действие:
                '1'             - зашифровать сообщение
                '2'             - расшифровать сообщение
                'Другой символ' - выход""");
        char symbol = scan.next().charAt(0);
        if (symbol == '1') {
            message = mess.nextLine();
            ciphText(message);
        } else if (symbol == '2') {
            message = mess.nextLine();
            deciphText(message);
        } else isStop = true;
    }

    public static void main(String[] args) {

        Text text = new Text();
        while (!text.isStop) {
            text.work();
        }
    }
}
