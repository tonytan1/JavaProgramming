package SelfSimilarityTree;

/**
 * Created by tonytan on 25/5/15.
 *
 * This defines a recursion that creates a self similar Tree.
 */

import java.awt.Graphics;

public class Tree {
    private final int START_X;
    private final int START_TIME;
    private final double MAX_TRUNK_LENGTH = 100;
    private double trunkLength;

    public Tree(int location, int startTime, double trunkLength){
        this.START_X = location;
        this.START_TIME = startTime;
        this.trunkLength = trunkLength;
    }

    int getSTART_X(){
        return START_X;
    }

    int getSTART_TIME(){
        return START_TIME;
    }

    double getTrunkLength(){
        return this.trunkLength;
    }

    public void drawBranches(Graphics g,
                             int x0, int y0, double length, double angle){
        double radians = angle * Math.PI/180;
        int x1 = x0 + (int)(length*Math.cos(radians));
        //negate y increment to flip image vertically.
        int y1 = y0 - (int)(length*Math.sin(radians));

        if(length > 2){
            g.drawLine(x0, y0, x1, y1);
            drawBranches(g, x1, y1, length*0.75, angle + 30);
            drawBranches(g, x1, y1, length*0.67, angle - 50);
        }
    }

    //this employs the logitistic equation to generate bounded
    //growth along an S-curve like .

    public void updateTrunkLength(){
        trunkLength = trunkLength + 0.01*trunkLength*
                (1.0 - trunkLength/MAX_TRUNK_LENGTH);
    }
}
