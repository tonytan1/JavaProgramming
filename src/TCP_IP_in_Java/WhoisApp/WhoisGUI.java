package TCP_IP_in_Java.WhoisApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by tonytan on 6/7/15.
 *
 * A GUI interface of whois.java
 */
public class WhoisGUI extends JFrame {
    private JTextField searchString = new JTextField(30);
    private JTextArea names = new JTextArea(15, 80);
    private JButton findButton = new JButton("Find");
    private ButtonGroup searchIn = new ButtonGroup();
    private ButtonGroup searchFor = new ButtonGroup();
    private JCheckBox exactMatch = new JCheckBox("Exact Match", true);
    private JTextField chosenServer = new JTextField();
    private Whois server;// ?

    public WhoisGUI(Whois whois){
        super("Whois");
        this.server = whois;
        Container pane = this.getContentPane();

        Font f = new Font("Monospaced", Font.PLAIN, 12);
        names.setFont(f);
        names.setEditable(false);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1,1,10,10));
        JScrollPane jsp = new JScrollPane(names);
        centerPanel.add(jsp);
        pane.add("Center", centerPanel);

        //You don't want the buttons in the south and north
        //to fill the entire sections so add Panels there
        //and use FlowLayouts in the Panel
        JPanel northPanel = new JPanel();
        JPanel northPanelTop = new JPanel();
        northPanelTop.setLayout(new FlowLayout(FlowLayout.LEFT));
        northPanelTop.add(new JLabel("Whois: "));
        northPanelTop.add("North", searchString);
        northPanelTop.add(exactMatch);
        northPanelTop.add(findButton);
        northPanel.setLayout(new BorderLayout(2, 1));
        northPanel.add("North", northPanelTop);
        JPanel northPanelBottm = new JPanel();
        northPanelBottm.setLayout(new GridLayout(1, 3, 5, 5));
        northPanelBottm.add(initRecordType());
        northPanelBottm.add(initSearchFields());
        northPanelBottm.add(initServerChoice());
        northPanel.add("Center", northPanelBottm);

        pane.add("North", northPanel);

        ActionListener al = new LookupNames();
        findButton.addActionListener(al);
        searchString.addActionListener(al);
    }

    private JPanel initRecordType(){
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6, 2, 5, 2));
        p.add(new JLabel("Search for: "));
        p.add(new JLabel(""));

        JRadioButton any = new JRadioButton("Any", true);
        any.setActionCommand("Any");
        searchFor.add(any);
        p.add(any);


        p.add(this.makeRadioButton("Network"));
        p.add(this.makeRadioButton("Person"));
        p.add(this.makeRadioButton("Host"));
        p.add(this.makeRadioButton("Domain"));
        p.add(this.makeRadioButton("Organization"));
        p.add(this.makeRadioButton("Group"));
        p.add(this.makeRadioButton("Gateway"));
        p.add(this.makeRadioButton("ASN"));

        return p;
    }

    private JRadioButton makeRadioButton(String label){
        JRadioButton button = new JRadioButton(label, false);
        button.setActionCommand(label);
        searchFor.add(button);
        return button;
    }

    private JRadioButton makeSearchInRatioButton(String label){
        JRadioButton button = new JRadioButton(label, false);
        button.setActionCommand(label);
        searchIn.add(button);
        return button;
    }

    private JPanel initSearchFields(){
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6, 1, 5, 2));
        p.add(new JLabel("Search In: "));

        JRadioButton all = new JRadioButton("All", true);
        all.setActionCommand("All");
        searchIn.add(all);
        p.add(all);

        p.add(this.makeSearchInRatioButton("Name"));
        p.add(this.makeSearchInRatioButton("Mailbox"));
        p.add(this.makeSearchInRatioButton("Handle"));

        return p;
    }

    private JPanel initServerChoice(){
        final JPanel p = new JPanel();
        p.setLayout(new GridLayout(6, 1, 5, 2));
        p.add(new JLabel("Search at: "));

        chosenServer.setText(server.getHost().getHostName());
        p.add(chosenServer);
        chosenServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    InetAddress newHost =
                            InetAddress.getByName(chosenServer.getText());
                    Whois newServer = new Whois(newHost);
                    server = newServer;
                }catch (Exception e){
                    JOptionPane.showMessageDialog(p,
                            e.getMessage(),"Alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return p;
    }
    class LookupNames implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            Whois.SearchIn group = Whois.SearchIn.ALL;
            String searchInLabel = searchIn.getSelection().getActionCommand();
            if (searchInLabel.equals("Name")) {
                group = Whois.SearchIn.NAME;
                if (searchInLabel.equals("All")){
                    searchIn.getSelection().setSelected(false);
                }
            }
            else if (searchInLabel.equals("Mailbox")){
                group = Whois.SearchIn.MAILBOX;
            }
            else if (searchInLabel.equals("Handle")){
                group = Whois.SearchIn.HANDLE;
            }

            Whois.SearchFor category = Whois.SearchFor.ANY;
            String searchForLabel = searchFor.getSelection().getActionCommand();
            if (searchForLabel.equals("Network")){
                category = Whois.SearchFor.NETWORK;
            }
            else if (searchForLabel.equals("Group")){
                category = Whois.SearchFor.GROUP;
            }
            else if (searchForLabel.equals("ASN")){
                category = Whois.SearchFor.ASN;
            }
            else if (searchForLabel.equals("Domain")){
                category = Whois.SearchFor.DOMAIN;
            }
            else if (searchForLabel.equals("Gateway")){
                category = Whois.SearchFor.GATEWAY;
            }
            else if (searchForLabel.equals("Person")){
                category = Whois.SearchFor.PERSON;
            }
            else if (searchForLabel.equals("Host")){
                category = Whois.SearchFor.HOST;
            }
            else if (searchForLabel.equals("Organization")){
                category = Whois.SearchFor.ORGANIZATION;
            }

            try {
                names.setText("");
                server.setHost(chosenServer.getText());
                String result = server.lookUpNames(searchString.getText(),
                        category, group, exactMatch.isSelected());
                names.setText(result);
            }catch (IOException ex){
                JOptionPane.showMessageDialog(WhoisGUI.this,
                        ex.getMessage(), "Lookup Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args){
        try {
            Whois server = new Whois();
            WhoisGUI a = new WhoisGUI(server);
            a.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            a.pack();
            EventQueue.invokeLater(new FrameShower(a));
        }catch (UnknownHostException e){
            JOptionPane.showMessageDialog(null, "Could not locate default host"+
             Whois.DEFAULT_HOST, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static class FrameShower implements Runnable{
        private final Frame frame;

        FrameShower(Frame frame){
            this.frame = frame;
        }

        public void run(){
            frame.setVisible(true);
        }
    }

}


