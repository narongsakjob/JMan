import java.awt.Color;

public class Block extends Piece{
	public Block (int x , int y , Map m){
		super(0,m);
		this.setX(x);
		this.setY(y);
		this.setColor(Color.WHITE);
	}

	@Override
	public void act() {
		this.setActed(true);
	}

}
