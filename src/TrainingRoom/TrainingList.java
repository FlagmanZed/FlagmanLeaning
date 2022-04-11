package TrainingRoom;


public class TrainingList {

    public static void main(String[] args) {

        Programmer prog = new Programmer("Алексей", "Софтлайн");
        System.out.println(prog.getPosition());
        prog.work();
        System.out.println(prog.getPosition());
        prog.work();
        prog.work();
        System.out.println(prog.getPosition());
    }
}