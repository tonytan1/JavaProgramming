package ShowMeCode; /**
 * Created by tony.tan on 6/4/2015.
 *
 * This program manages an ArrayList of student.
 */
import java.util.ArrayList;
import java.util.InputMismatchException;

public class StudentList {
    private ArrayList<String> students = new ArrayList<>();

    public StudentList(String[] names){
        for(int i=0; i<names.length; i++){
            students.add(names[i]);
        }
    }

    public void dispaly(){
        for(int i=0; i<students.size();i++){
            System.out.println(students.get(i) +" ");
        }
        System.out.println();
    }

    public String removeStudent(int index)
            throws IndexOutOfBoundsException, InputMismatchException {
        return students.remove(index);
    }
}
