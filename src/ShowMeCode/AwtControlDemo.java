package ShowMeCode; /**
 * Created by tonytan on 28/5/15.
 */

import java.awt.*;
import java.awt.event.*;

public class AwtControlDemo {

    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPannel;

    public AwtControlDemo(){
        prepareGUI();
    }

    public static void main(String[] args){
        AwtControlDemo awtControlDemo = new AwtControlDemo();
        awtControlDemo.showEventDemo();
    }

    private void prepareGUI(){
        mainFrame = new Frame("Java AWT Example");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350, 100);

        controlPannel = new Panel();
        controlPannel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPannel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo(){
        headerLabel.setText("Control in action: Button");

        Button okButton = new Button("OK");
        Button submitButton = new Button("Submit");
        Button cancleButton = new Button("Cancle");

        okButton.setActionCommand("OK");
        submitButton.setActionCommand("Submit");
        cancleButton.setActionCommand("Cancle");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancleButton.addActionListener(new ButtonClickListener());

        controlPannel.add(okButton);
        controlPannel.add(submitButton);
        controlPannel.add(cancleButton);

        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.equals("OK")){
                statusLabel.setText("OK button clicked");
            }
            else if(command.equals("Submit")){
                statusLabel.setText("Submit Button clicked");
            }
            else {
                statusLabel.setText("Cancel button clicked");
            }
        }
    }
}
