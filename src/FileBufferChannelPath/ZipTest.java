package FileBufferChannelPath;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.filechooser.FileFilter;
/**
 * Created by tonytan on 11/7/15.
 */
public class ZipTest {
    public static void main(String[] args){
        ZipTestFrame frame = new ZipTestFrame();
        frame.setTitle("ZipTest");
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
/**
 * A frame with a text area to show the contents of a file
 * inside a zip archive, a combo box to select differnent
 * files in the archive, and a menu to load a new archive.
 *
 */
class ZipTestFrame extends JFrame{
    public ZipTestFrame(){
        //add the menu and the Open and Exit menu item
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new OpenAction());

        JMenuItem exitItem =  new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuBar.add(menu);
        setJMenuBar(menuBar);

        //add the text area and combo box
        JTextArea fileText = new JTextArea();
        final JComboBox fileCombo = new JComboBox();
        fileCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadZipFile((String) fileCombo.getSelectedItem());
            }
        });

        Container contentPane = getContentPane();
        contentPane.add(fileCombo, BorderLayout.SOUTH);
        contentPane.add(fileText, BorderLayout.CENTER);
    }

    /**
     * This is the listener for the File->Open menu item.
     */
    private class OpenAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //prompt the user for a zip file
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            ExtensionFileFilter filter = new ExtensionFileFilter();
            filter.addExtension(".zip");
            filter.addExtension(".jar");
            filter.setDescription("ZIP archives");
            chooser.setFileFilter(filter);
            int r = chooser.showOpenDialog(ZipTestFrame.this);
            if (r == JFileChooser.APPROVE_OPTION){
                zipname = chooser.getSelectedFile().getPath();
                scanZipFile();
            }
        }
    }


    /**
     * Scans the contents of the zip archive and populates
     * the combo box.
     */
    public void scanZipFile(){
        fileCombo.removeAllItems();
        try {
            ZipInputStream zin = new ZipInputStream(new
                    FileInputStream(zipname));
            ZipEntry entry;
            while ((entry = zin.getNextEntry())!= null){
                String s = entry.getName();
                fileCombo.add(s,fileText);
                zin.closeEntry();
            }
            zin.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads a file from the zip archive into the text area
     *
     * @param name the name of the file in the archive.
     */
    public void loadZipFile(String name){
        try {
            ZipInputStream zin = new ZipInputStream(
                    new FileInputStream(zipname));
            ZipEntry entry;
            fileText.setText("");

            //find entry with matching name in archive
            //java.util.zip.ZipInputStream.getNextEntry()
            while ((entry = zin.getNextEntry())!=null) {
                if (entry.getName().equals(name)) {
                    //read entry into the text area
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(zin));
                    String line;
                    while ((line = in.readLine()) != null) {
                        fileText.append(line);
                        fileText.append("\n");
                    }
                }
                zin.closeEntry();
            }
            zin.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private JComboBox fileCombo;
    private JTextArea fileText;
    private String zipname;
}

/**
 * This file filter matches all files with a given set
 * of extensions.
 */
class ExtensionFileFilter extends FileFilter {
    /**
     * Add an extension that this file filter recognizes.
     * @param extension a file extension(such as".txt" or "txt".
     *
     */
    public void addExtension(String extension){
        if (!extension.startsWith("."))
            extension = "."+extension;
        extensions.add(extension.toLowerCase());
    }
    /**
     * Sets a description for the file set that this file filter
     * recognizes.
     * @param aDescription a description for the file set
     */
    public void setDescription(String aDescription){
        String description = aDescription;
    }
    public String getDescription(){
        return description;
    }

    public boolean accept(File f){
        if (f.isDirectory()) return true;
        String name = f.getName().toLowerCase();

        //check if the file name ends with any of the extensions
        for (int i=0;i<extensions.size();i++){
            if (name.endsWith((String) extensions.get(i)))
                return true;
        }
        return false;
    }

    private String description = "";
    private ArrayList extensions = new ArrayList();
}
