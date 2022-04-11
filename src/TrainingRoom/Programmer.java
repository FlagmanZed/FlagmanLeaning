package TrainingRoom;


//        метод getPosition(), возвращающий строку — позицию программиста.
//        метод work(), поднимающий позицию программиста на уровень вверх (с самого начала (при инициализации) программист — intern (стажер), потом junior (джуниор), далее middle, senior, lead).

public class Programmer {

    String name;
    String company;
    String position;
    int positionCount = 0;


    public Programmer(String name, String company) {
        this.name = name;
        this.company = company;
    }


    void work() {
        String[] positionArr = new String[]{"intern", "junior", "middle", "senior", "lead"};
        if (positionCount >= positionArr.length) position = positionArr[positionArr.length - 1];
        else {
            position = positionArr[positionCount];
            positionCount++;
        }
    }

    public String getPosition() {
        return position;
    }
}
