import java.awt.Graphics;

/**
 * @author Aman Ambastha CS160 - 03 Program 3
 *
 */
public abstract class Racer {
	private String ID;	// racer ID
	private int x;			// x position
	private int y;			// y position
	private boolean isWinner;

	/** default constructor
	 *  Sets ID to blank
	 *  isWinner to false
	 */
	public Racer() {
		ID = "";
		isWinner = false;
	}
	
	/** Constructor
	 * @param rID	racerID
	 * @param rX	x position
	 * @param rY	y position
	 * isWinner to false
	 */
	public Racer(String rID, int rX, int rY) {
		ID = rID;
		x = rX;
		y = rY;
		isWinner = false;
	}
	/** accessor for ID
	 * @return	ID
	 */
	public String getID() {
		return ID;
	}
	
	/** accessor for x
	 * @return	current x value
	 */
	public int getX() {
		return x;
	}
	
	/** accessor for y
	 * @return	current y value
	 */
	public int getY() {
		return y;
	}

	/** mutator for x
	 * @param	newX	new value for x
	 */
	public void setX(int newX) {
		x = newX;
	}

	/** mutator for y
	 * @param 	newY	new value for y
	 */
	public void setY(int newY) {
		y = newY;
	}
	/** mutator for isWinner
	 * @param	winner	new value for isWinner
	 */
	public void setWinner(boolean winner) {
		isWinner = winner;
	}
	/** accessor for isWinner
	 * @return	current isWinner boolean value
	 */
	public boolean getWinner() {
		return isWinner;
	}

	/** abstract method for Racer's move
	 */
	public abstract void move();
	
	/** abstract method for drawing Racer
	 *  @param	g	Graphics context
	 */
	public abstract void draw(Graphics g);

	/** abstract method for morphing Racer if Racer Wins
	 *  @param	g	Graphics context
	 */
	public abstract void morph(Graphics g);
	
}
