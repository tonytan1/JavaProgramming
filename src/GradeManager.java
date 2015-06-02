/**
 * Created by tonytan on 2/6/15.
 *
 * This program reads course percentages and calculates GPA.
 */
import java.util.Scanner;

public class GradeManager {
    private enum Grade {F, D, C, B, A}

    public static void main(String[] args){
        int numOfCourse=0;
        Grade grade;
        int totalPts = 0;

        do{
            grade = getGrade();

            if(grade != null){
                numOfCourse++;
                switch (grade){
                    case A:
                        totalPts += 4;
                        break;
                    case B:
                        totalPts +=3;
                        break;
                    case C:
                        totalPts +=2;
                        break;
                    case D:
                        totalPts +=1;
                        break;
                }
            }

            if (grade == Grade.F){
                System.out.println("If this is a required course, you must retake it");
            }

            if (grade.ordinal() < Grade.C.ordinal()){// ordinal return the position/order in enum.
                System.out.println("If this is a prerequisite course for"+
                " a required course, you must retake it");
            }
        }while (grade != null);

        if (numOfCourse == 0){
            System.out.println("No scores were entered.");
        }
        else {
            System.out.printf("Overall GPA: %.2f", (float) totalPts / numOfCourse);
        }
    }

    private static Grade getGrade(){
        Scanner stdIn = new Scanner(System.in);
        float percentage;
        Grade grade = null;

        System.out.println("Enter course overall percentage: ");
        percentage = stdIn.nextFloat();

        if (percentage >= 90.0)
            grade = Grade.A;
        else if (percentage >= 80.0)
            grade = Grade.B;
        else if (percentage >= 70.0)
            grade = Grade.C;
        else if (percentage >= 60.0)
            grade = Grade.D;
        else if (percentage >= 0.0)
            grade = Grade.F;

        return grade;
    }
}
