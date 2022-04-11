package TrainingRoom;

//  Напишите класс Separator.
//  Добавьте в него поле array и конструктор, инициализирующий его.
//  Также реализуйте методы even() и odd(), они должны возвращать массив четных или нечетных чисел, отобранных из array.

public class Separator {
    int[] array;

    public Separator(int[] array) {
        this.array = array;
    }

    public int[] even() {
        int lengthEven = 0;
        for (int j : array) {
            if (j % 2 == 0) lengthEven++;
        }
        int[] evenArr = new int[lengthEven];
        for (int j : array) {
            if (j % 2 == 0) {
                evenArr[lengthEven - 1] = j;
                lengthEven--;
            }
        }
        return evenArr;
    }

    public int[] odd() {
        int lengthOdd = 0;
        for (int j : array) {
            if (j % 2 != 0) lengthOdd++;
        }
        int[] oddArr = new int[lengthOdd];
        for (int j : array) {
            if (j % 2 != 0) {
                oddArr[lengthOdd - 1] = j;
                lengthOdd--;
            }
        }
        return oddArr;
    }
}