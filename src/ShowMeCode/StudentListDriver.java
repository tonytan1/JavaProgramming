package ShowMeCode; /**
 * Created by tony.tan on 6/4/2015.
 *
 * This drives the ShowMeCode.StudentList class.
 */
import java.util.Scanner;

public class StudentListDriver {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        String[] names = {"allen", "bert", "carol", "duff"};
        StudentList studentList = new StudentList(names);
        int index;
        boolean reenter;

        studentList.dispaly();

        do {
            System.out.print("Enter index of student to remove: ");
            index = stdIn.nextInt();
            try {
                System.out.println("Removed"+ studentList.removeStudent(index));
                reenter = false;
                studentList.dispaly();
            }
            catch (IndexOutOfBoundsException E){
                System.out.print("Invalid entry. ");
                reenter = true;
            }
        }while (reenter);
    }
}
