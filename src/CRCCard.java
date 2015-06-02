/**
 * Created by tonytan on 27/5/15.
 *
 * This program create a GUI display of CRC card.
 */

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;

public class CRCCard {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        String input;

        System.out.print("Enter class name or 'q' to quit: ");
        input = stdIn.nextLine();
        while (!input.equalsIgnoreCase("q")){
            JFrame frame = new JFrame("Class: "+ input);
            JTextArea responsibilities =
                    new JTextArea("RESPONSIBILITIES: \n");
            JTextArea collaborators =
                    new JTextArea("COLLABORATORS:\n");
            JSplitPane splitPane =
                    new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                            responsibilities, collaborators);

            frame.setSize(500, 300);
            frame.add(splitPane);
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
            frame.toFront();
            splitPane.setDividerLocation(0.67);

            System.out.print("Enter class name or 'q' to quit: ");
            input = stdIn.nextLine();
        }
    }
}
