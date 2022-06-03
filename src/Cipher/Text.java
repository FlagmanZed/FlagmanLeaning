package Cipher;

import java.util.Arrays;
import java.util.Scanner;

public class Text {

    private int[] arrSumWords, arrSumChar;

    // преобразуем текст в массивы
    void codeText(String txtForNum) {
        String[] text = txtForNum.trim().split(" ");
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

    void ciphText(int[] arrSumChar) {
        for (int i = 0; i < arrSumChar.length; i++){
            arrSumChar[i] = arrSumChar[i]*2-arrSumChar.length-i;
        }
    }

    void deciphText(String txtForDeciph) {
        codeText(txtForDeciph);
        for (int i = 0; i < arrSumChar.length; i++){
            arrSumChar[i] = (arrSumChar[i]+arrSumChar.length+i)/2;
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


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String txtForCiph = scan.nextLine();
        Text text = new Text();

        text.codeText(txtForCiph);
        text.ciphText(text.arrSumChar);
        System.out.println(text.printText(text.arrSumWords, text.arrSumChar));
        System.out.println(Arrays.toString(text.arrSumChar));
        System.out.println(Arrays.toString(text.arrSumWords));

        String txtForDeciph = scan.nextLine();
        text.deciphText(txtForDeciph);
        System.out.println(text.printText(text.arrSumWords, text.arrSumChar));
        System.out.println(Arrays.toString(text.arrSumChar));
        System.out.println(Arrays.toString(text.arrSumWords));
    }
}
