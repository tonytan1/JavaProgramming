import java.util.ArrayDeque;

/**
 * Created by tony.tan on 5/21/2015.
 *
 * This program uses stacks to help with a driver parking service.
 */
import java.util.ArrayDeque;
import java.util.Scanner;

public class DrivewayParking {
    private ArrayDeque<String> driveway1 = new ArrayDeque<String>();
    private ArrayDeque<String> driveway2 = new ArrayDeque<String>();

    public void describeDriveways(){
        System.out.println("driveway1" + driveway1);
        System.out.println("driveway2" + driveway2);
    }

    private void parkCar(String liscensePlate){
        if(driveway1.size()<=driveway2.size()){
            driveway1.push(liscensePlate);
        }
        else{
            driveway2.push(liscensePlate);
        }
    }

    private boolean getCar(String liscensePlate){
        String otherPlate;

        if(driveway1.contains(liscensePlate)){
            otherPlate = driveway1.pop();
            while (!otherPlate.equals(liscensePlate)){
                driveway2.push(otherPlate);
                otherPlate = driveway1.pop();
            }
            return true;
        }
        else if(driveway2.contains(liscensePlate)){
            otherPlate =driveway2.pop();
            while (!otherPlate.equals(liscensePlate)){
                driveway1.push(otherPlate);
                otherPlate = driveway2.pop();
            }
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        char action;
        String licensePlate;
        DrivewayParking attendant = new DrivewayParking();

        do{
            attendant.describeDriveways();
            System.out.print("Enter +license to add, " +
                    "-license to remove, or q to quit: ");
            licensePlate = stdIn.nextLine();
            action = licensePlate.charAt(0);
            licensePlate = licensePlate.substring(1);//? to check
            switch (action){
                case '+':
                    attendant.parkCar(licensePlate);
                    break;
                case '-':
                    if (!attendant.getCar(licensePlate)){
                        System.out.println("sorry we couldn't find it.");
                    }
            }
        }
        while (action != 'q');
    }
}


