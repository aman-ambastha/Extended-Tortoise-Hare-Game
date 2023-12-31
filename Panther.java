/** Panther class
 *   inherits from abstract Racer class
 */
import java.awt.*;
import java.util.Random;

public class Panther extends Racer
{
    /** Default Constructor: calls Racer default constructor
     */
    public Panther() {
        super();
    }

    /** Constructor
     *    @param rID   racer ID, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public Panther(String rID, int rX, int rY)
    {
        super(rID,rX, rY);
    }

    /** move:  calculates the new x position for the racer Panther
     *   Panther move characteristics:
     *      1) Panther moves based on its current position given by getX()
     *      2) The amount a Panther can move is based on the multiplication two random numbers generated between the range 1-5
     *           * Therefore, the maximum a Panther can move is 25
     *      3) Panther's position will be within a certain range given by the if and else if statements
     *      4) Even is a panther's position is within one of ranges, Panther can only move if the amount a Panther
     *      can move if within the ranges specified by the nested if statement
     *           * For example, if a position is 75, it can only move if it moves by a value greater than or equal to 10
     *           * As shown by the if statements, as a panther gets closer to the finish line, it becomes harder for
     *             the panther to move because the value that a panther must move by gets larger.
     *           * For example, by the time a Panther has crossed 350, for it to move it must by 25. The maximum value
     *             generated by the multiplication of the two random numbers between range 1-5 (firstNum and secondNum).
     */
    public void move() {
        Random rand = new Random();
        int firstNum = rand.nextInt(5) + 1;
        int secondNum = rand.nextInt(5) + 1;
        int move = firstNum * secondNum;

        if (getX() <= 50) {
            if (move >= 5)
                setX(getX() + move);
        } else if (getX() >= 50 && getX() <= 100) {
            if (move >= 10)
                setX(getX() + move);
        } else if (getX() >= 100 && getX() <= 200) {
            if (move >= 15)
                setX(getX() + move);
        } else if(getX() >= 200 && getX() <= 350) {
            if (move >= 20)
                setX(getX() + move);
        }
        else{
            if(move == 25)
                setX(getX() + move);
        }
    }

    /** draw: draws the Panther at current (x, y) coordinate
     *   @param g   Graphics context
     */
    public void draw(Graphics g) {
        int startY = getY();
        int startX = getX();


        if(getWinner()){ // If Panther is winner, execute morph(g)
            morph(g);
        }
        else {
            g.setColor(Color.BLACK);
            g.fillOval(startX - 37, startY + 5, 10, 25);

            //body
            g.fillRoundRect(startX - 33, startY, 45, 15, 10, 10);

            //head
            g.fillOval(startX + 2, startY - 5, 25, 20);
            g.setColor(Color.WHITE);
            g.fillOval(startX + 9, startY - 1, 5, 5);
            g.fillOval(startX + 18, startY - 1, 5, 5);


            //legs
            g.setColor(Color.BLACK);
            g.fillRect(startX - 5, startY + 15, 5, 15);
            g.fillRect(startX - 20, startY + 15, 5, 15);

            //ear
            g.fillArc((startX - 15), startY - 7, 20, 20, 0, 90);
            g.fillArc((startX - 30), startY - 7, 20, 20, 0, 90);
        }
    }

    /**
     * Override morph(g) from abstract class Racer : Function used for the morphing behavior of the panther if the panther wins the race
     * @param g	Graphics context
     */
    @Override
    public void morph(Graphics g) {
        int startY = getY();
        int startX = getX() / 2;

        //tail
        g.setColor(Color.BLACK);
        g.fillOval(startX - 33, startY + 38, 35, 10);

        //body
        g.fillRoundRect(startX - 33, startY, 15, 45, 10, 10);

        //head
        g.fillOval(startX - 42, startY, 25,  20);
        g.setColor(Color.RED);
        g.fillOval(startX - 37,startY + 4 , 5, 5);
        g.fillOval(startX - 27, startY + 4, 5, 5);

        //legs
        g.setColor(Color.BLACK);
        g.fillRect(startX - 43, startY + 35, 20, 5);
        g.fillRect(startX - 43, startY + 20, 20, 5);

        //ear
        g.fillArc(startX - 30, startY + 10, 20, 20, 0, 90);
        g.fillArc(startX - 30, startY + 25, 20, 20, 0, 90);

        g.drawString("ROAR, I WIN", startX - 50, startY + 65);
    }
}
