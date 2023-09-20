/** JellyFish class
 *   inherits from abstract Racer class
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class JellyFish extends Racer
{
    /** Default Constructor: calls Racer default constructor
     */
    public JellyFish() {
        super();
    }

    /** Constructor
     *    @param rID   racer ID, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public JellyFish(String rID, int rX, int rY)
    {
        super(rID,rX,rY);
    }

    /** move:  calculates the new x position for the racer JellyFish
     *   JellyFish move characteristics:
     *   1) JellyFish is the fastest racer. But the JellyFish suffers from moving back and forth
     *   2) The JellyFish's ability to move is based on its ability to push (legpush) and the water's resistance
     *   (resistance).
     *   3) The values of legpush and resistance are randomly calculated by rand.nextInt(jump) + 1, where jump is a
     *   value between 50 - 100 inclusive.
     *   4) If the current position of a jellyfish + (legpush - resistance) goes less than 40, JellyFish gets reset at th beginning
     *   of the race at setX(40).
     *   5) Otherwise the JellyFish moves by the addition of (legpush - resistance) to getx().
     *         * If legpush > resistance, JellyFish moves forward
     *         * If resistance < legpush, JellyFish moves backward.
     */
    public void move() {
        Random rand = new Random();
        int jump = rand.nextInt(51) + 50;
        int legpush = rand.nextInt(jump) + 1;
        int resistance = rand.nextInt(jump) + 1;
        if(getX() + (legpush - resistance) < 40){
            setX(40);
        }
        else
            setX(getX() + (legpush - resistance));
    }

    /** draw: draws the JellyFish at current (x, y) coordinate
     *   @param g   Graphics context
     */
    public void draw(Graphics g) {
        if(getWinner()){ // If JellyFish is winner, execute morph(g)
            morph(g);
        }
        else {
            int startY = getY();
            int startX = getX();
            // body
            g.setColor(Color.BLUE);
            g.fillOval(startX - 37, startY + 8, 35, 35);
            g.setColor(Color.YELLOW);
            g.drawLine(startX - 18, startY + 15, startX - 5, startY + 25);
            g.drawLine(startX - 18, startY + 15, startX - 35, startY + 25);
            g.drawLine(startX - 35, startY + 25, startX - 5, startY + 25);
            // ears
            g.setColor(Color.GRAY);
            g.fillArc((startX - 28), startY + 1, 20, 20, 0, 90);
            g.fillArc((startX - 40), startY + 1, 20, 20, 0, 90);
            // flatten bottom body
            g.clearRect(startX - 37, startY + 33, 35, 10);
            // legs
            g.setColor(Color.RED);
            for (int x = 1; x <= 6; x++) {
                g.fillRoundRect(startX - (6 * x), startY + 31, 5, 7, 10, 10);
            }
        }

    }

    /**
     * Override morph(g) from abstract class Racer : Function used for the morphing behavior of JellyFish if the JellyFish wins the race
     * @param g	Graphics context
     */
    @Override
    public void morph(Graphics g) {
        int startX = getX() / 2;
        int startY = getY();
        // body
        g.setColor(Color.RED);
        g.fillOval(startX - 37,startY + 8, 35, 35);
        g.setColor(Color.BLACK);
        g.drawLine(startX - 18, startY + 15 , startX - 5, startY + 25);
        g.drawLine(startX - 18, startY + 15, startX - 35, startY + 25);
        g.drawLine(startX - 35, startY + 25, startX - 5, startY + 25);
        // ears
        g.setColor(Color.GREEN);
        g.fillArc((startX - 28), startY + 1, 20, 20, 0, 90);
        g.fillArc((startX - 40), startY + 1, 20, 20, 0,  90);
        // flatten bottom body
        g.clearRect(startX - 37, startY + 33, 35, 10);
        // legs
        g.setColor(Color.BLUE);
        for(int x = 1; x <= 6; x++) {
            g.fillRoundRect(startX - (6 * x), startY + 31, 5, 7, 10, 10);
        }
        g.drawString("JellyFish Won !!", startX - 50, startY + 65);

    }
}