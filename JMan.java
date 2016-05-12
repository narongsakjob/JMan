import java.awt.*;

/** An instance of this class is a J*Man.
 There should at most one J*Man in a game board at a time*/
public class JMan extends Piece {

	/** Constructor: a new J*Man at position (x, y) on Map m
     with color red if c = 0, green if c = 1, and yellow if c = 2. */
	public JMan(int x, int y, int c, Map m){
		super(Piece.JMAN, m);

		this.setX(x);
		this.setY(y);

		if(c==0) this.setColor(Color.RED);
		else if(c==1) this.setColor(Color.GREEN);
		else this.setColor(Color.YELLOW);


		// Complete this
	}

	/** Constructor: a new J*Man at position (x, y) on Map m
     with color c. Precondition: c is one of
     Color.RED, Color.GREEN, and Color.YELLOW.*/
	public JMan(int x, int y, Color c, Map m){
		super(Piece.JMAN, m);
		this.setX(x);
		this.setY(y);
		this.setColor(c);
		// Complete this;
	}

	/** J*Man should move based on what button is pushed.
     This method is not used. */
	public void act(){
	}

	/** Move J*Man one step based on the value of i:
        0 = up, 1 = down, 2 = left, 3 = right. */
	public void step(int i){
		Piece p;
        if(i == 0) {
            if(this.getMap().isInGrid(this.getX(), this.getY() - 1)) {
                p = this.getMap().pieceAt(this.getX(), this.getY() - 1);
                if(p == null) {
                    this.getMap().move(this.getX(), this.getY(), this.getX(), this.getY() - 1);
                   
                } else if(p.getType() != 0 && this.canEat(p)) {
                    this.setColor(p.getColor());
                    this.getMap().move(this.getX(), this.getY(), this.getX(), this.getY() - 1);
                    
                }
            }
        } else if(i == 1) {
            if(this.getMap().isInGrid(this.getX(), this.getY() + 1)) {
                p = this.getMap().pieceAt(this.getX(), this.getY() + 1);
                if(p == null) {
                    this.getMap().move(this.getX(), this.getY(), this.getX(), this.getY() + 1);
                    
                } else if(p.getType() != 0 && this.canEat(p)) {
                    this.setColor(p.getColor());
                    this.getMap().move(this.getX(), this.getY(), this.getX(), this.getY() + 1);
             
                }
            }
        } else if(i == 2) {
            if(this.getMap().isInGrid(this.getX() - 1, this.getY())) {
                p = this.getMap().pieceAt(this.getX() - 1, this.getY());
                if(p == null) {
                    this.getMap().move(this.getX(), this.getY(), this.getX() - 1, this.getY());
                    
                } else if(p.getType() != 0 && this.canEat(p)) {
                    this.setColor(p.getColor());
                    this.getMap().move(this.getX(), this.getY(), this.getX() - 1, this.getY());
                   
                }
            }
        } else if(this.getMap().isInGrid(this.getX() + 1, this.getY())) {
            p = this.getMap().pieceAt(this.getX() + 1, this.getY());
            if(p == null) {
                this.getMap().move(this.getX(), this.getY(), this.getX() + 1, this.getY());
                
            } else if(p.getType() != 0 && this.canEat(p)) {
                this.setColor(p.getColor());
                this.getMap().move(this.getX(), this.getY(), this.getX() + 1, this.getY());
                
            }
        }


		setActed(true);

		// Complete this
	}

	private boolean canEat(Piece p){
		return this.getColor() == Color.RED && p.getColor() == Color.YELLOW || this.getColor() == Color.GREEN && p.getColor() == Color.RED || this.getColor() == Color.YELLOW && p.getColor() == Color.GREEN;                              
	}

	/** = representation of this piece */
	public String toString() {
		String color= "";
		return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
	}
}
