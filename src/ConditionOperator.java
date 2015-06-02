import java.util.Scanner;

/**
 * Created by tonytan on 1/6/15.
 *
 * Use condition operator for practice
 */
public class ConditionOperator {

    public static int finalScore(int score,boolean isCredit){
        score += isCredit? 2:0;
        return score;
    }

    public static void main(String[] args){
        System.out.println("PLS enter your score: ");
        Scanner stdIn = new Scanner(System.in);
        int score = stdIn.nextInt();
        System.out.println("Are u credit(true or false)");
        Scanner stdIn1 = new Scanner(System.in);
        boolean isCredit = stdIn1.nextBoolean();

        System.out.print("\nyour final score is " + finalScore(score, isCredit));
        System.out.println(finalScore(score, isCredit)>60?" pass":" fail");
    }
}
