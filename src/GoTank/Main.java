package GoTank;

public class Main {


    public static void main(String[] args) {
/*
Make (add code to class Tank),
with fuel and different constructors
*/

        // At (0;0) fuel=100
        Tank justTank = new Tank();
        // At (10;10) fuel=100
        System.out.println(justTank.fuel);
        Tank anywareTank = new Tank(10, 10);
        // At (20;30) fuel=200
        Tank customTank = new Tank(20, 30, 200);
        justTank.goForward(50);
        justTank.printPosition();
        justTank.turnLeft();
        justTank.goForward(30);
        justTank.printPosition();
        justTank.turnLeft();
        justTank.goForward(50);
        justTank.printPosition();
        System.out.println(justTank.fuel);

        anywareTank.goBackward(-200);
        anywareTank.printPosition();
        customTank.goForward(201);
        customTank.printPosition();

/*
This fragment of code has to output

The Tank is at 100, 0 now.
The Tank is at 110, 10 now.
The Tank is at 220, 30 now.

*/
    }

}
