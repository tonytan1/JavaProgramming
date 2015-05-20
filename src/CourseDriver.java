/**
 * Created by tony.tan on 5/18/2015.
 */

import java.util.Scanner;

public class CourseDriver {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int[] ids = {1111, 2222, 3333, 44444};
        Course course = new Course("CS101",ids, ids.length);
        int id;
        int index;

        System.out.print("enter a four-digit ID: ");
        id = stdIn.nextInt();
        index = course.findStudent(id);
        if(index >=0){
            System.out.println("find at index" + index);
        }
        else{
            System.out.println("not found");
        }

    }
}
