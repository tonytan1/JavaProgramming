package TypeAndASCIISet;

/**
 * Created by tonytan on 1/6/15.
 *
 * Promote type in method call.
 */
public class MethodPromotion {
    public static void main(String[] args){
        float x = 4.5f;

        printSquare(x);// automatic promotion
        printSquare(3);

        double i = 1234.5;
        int j = (int) i;//type casting

        System.out.println("i= "+ i + "\nj= "+j);
    }

    private static void printSquare(double num){
        System.out.println(num*num);
    }
}
