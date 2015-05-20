/**
 * Created by tony.tan on 5/18/2015.
 */
public class Course {
    private String courseName;
    private int[] ids;
    private int filledElement;

    public Course(String courseName, int[] ids, int filledElement){
        this.courseName = courseName;
        this.ids = ids;
        this.filledElement= filledElement;
    }//end constructor

    public int findStudent(int id){
        for(int i=0; i < filledElement; i++){
            if(ids[i] == id){
              return i;
            }
        }
        return -1;
    }

}
