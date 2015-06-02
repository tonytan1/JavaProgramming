/**
 * Created by tony.tan on 5/20/2015.
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class StockAverage {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        ArrayList<Double> stocks = new ArrayList<>();
        //The Double class wraps a value of the primitive type double
        // in an object.An object of type Double
        // contains a single field whose type is double.

        double stock;
        double stockSum = 0;

        System.out.print("Enter a stock value(-1 to quit):");
        try {
            stock = stdIn.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println("pls enter a num with right format ^-^:");
            stock = -1;
        }//TEST

        while (stock >= 0){
            stocks.add(stock);//Autoboxing is the process of automatically
            // wrapping a primitive value in a appropriate wrapper class
            // whenever there's an attempt tp use a primitive value
            // in a place that expects a primitive.
            System.out.print("Enter a stock value(-1 to quit):");
            try {
                stock = stdIn.nextDouble();
            }
            catch (InputMismatchException e){
                System.out.println("pls enter a num with right format ^-^:");
                stock = -1;
            }
        }


        for(double s:stocks){
            stockSum += s;
        }

        if(stocks.size() != 0){
            System.out.printf("\nAverage stock value = $%.2f\n",
                    stockSum/stocks.size());
        }
    }


}
