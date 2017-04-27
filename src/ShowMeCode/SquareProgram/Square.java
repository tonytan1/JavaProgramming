package ShowMeCode.SquareProgram;

/**
 * Created by tonytan on 26/5/15.
 *
 * This class manages squares.
 */

import java.util.Scanner;

public class Square {
    private int width;

    public Square(int width){
        this.width = width;
    }

    public int getArea(){
        return this.width * this.width;
    }

    public void draw(){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("print with (b)order or (s)olid ?");
        if(stdIn.nextLine().charAt(0) == 'b'){
            drawBorderSquare();
        }else{
            drawSolidSquare();
        }
    }

    private void drawBorderSquare(){
        System.out.println("In drawBorderSquare");
    }

    private void drawSolidSquare(){
        System.out.println("In drawSolidSquare");
    }

}
