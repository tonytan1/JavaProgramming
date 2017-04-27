package ShowMeCode.SquareProgram;

/**
 * Created by tonytan on 26/5/15.
 * @author tonytan
 *
 * This is the driver for the Square class.
 */

import java.util.Scanner;

public class SquareDriver {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        Square square;

        System.out.print("Enter the width of desired square: ");
        square = new Square(stdIn.nextInt());
        System.out.println("Area = "+ square.getArea());
        square.draw();
    }

}
