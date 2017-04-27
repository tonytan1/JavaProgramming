package DataStructure.SelfSimilarityTree;

/**
 * Created by tonytan on 25/5/15.
 *
 * This displays growing trees.
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class TreePanel extends JPanel{
    private final int HEIGHT;
    private final int WIDTH;
    private ArrayList<Tree> trees = new ArrayList<>();
    private int time = 0;

    public TreePanel (int frameHeight, int frameWidth){
        this.HEIGHT = frameHeight;
        this.WIDTH = frameWidth;
    }

    public void setTime(int time){
        this.time = time;
    }

    public void addTree(int location, double trunkLength, int plantTime){
        trees.add(new Tree(location, plantTime, trunkLength));
    }

    public ArrayList<Tree> getTrees(){
        return this.trees;
    }

    public void paintComponent(Graphics g){
        int location;//horizontal starting position of a tree.
        String age;

        super.paintComponent(g);//draw a horizontal line representing surface of the earth
        g.drawLine(25, HEIGHT - 75, WIDTH - 45, HEIGHT - 75);
        for(Tree tree: trees){
            //draw current tree
            location =  tree.getSTART_X();
            tree.drawBranches(g, location, HEIGHT - 75, tree.getTrunkLength(), 90);
            //write the age of current tree
            age  = Integer.toString((time - tree.getSTART_TIME())/12);
            g.drawString(age, location - 5, HEIGHT - 50);
        }
    }
}
