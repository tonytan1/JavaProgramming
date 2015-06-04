package TypeAndASCIISet;

/**
 * Created by tony.tan on 6/3/2015.
 * @author tony.tan
 *
 * This prints unicode characters.
 */

import javax.swing.*;
import java.awt.Font;

public class UnicodeDispaly {
    public static void main(String[] args){
        int[] codes = {'\u0391', '\u0410', '\u2200', '\u2500', '\u2700'};
        String[] descriptions = {
                "Greek", "Cyrillic (Russian)", "mathematical operators",
                "box drawing", "dingbats"
        };
        JFrame window = new JFrame("Some Unicode Description");
        JTextArea area = new JTextArea();
        Font font = new Font(Font.DIALOG, Font.PLAIN, 12);

        window.setSize(600, 305);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(area);
        area.setFont(font);
        area.setLineWrap(true);//when go to end of line, auto go to next line.
        area.append("Font type, style, and size: " +
        font.getFontName() + ", "+ font.getSize() + "\n");
        for(int i=0; i<codes.length; i++){
            area.append("0x"+Integer.toString(codes[i], 16)+
            " " + descriptions[i] + ":\n");
            for(int j=0; j<=72; j++){
                area.append((char)(codes[i]+j)+" ");
            }
            area.append("\n");
        }
        window.setVisible(true);

    }
}
