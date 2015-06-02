/**
 * Created by tony.tan on 6/2/2015.
 *
 * This program calculates and prints a purchase order report.
 */
import javax.swing.JOptionPane;

public class printPOGUI {
    public static void main(String[] args){
        String itemName;
        double price;
        int qty;

        itemName = JOptionPane.showInputDialog("name of purchase item:");
        price = Double.parseDouble(
                JOptionPane.showInputDialog("Price of one item")
        );
        qty = Integer.parseInt(
                JOptionPane.showInputDialog("Quantity:")
        );
        JOptionPane.showMessageDialog(null,
                "PURCHASE ODER:\n\n"+"Item: "+itemName +"\nQuantity: "+qty+
        "\nTotal price: $"+price*qty);
    }
}
