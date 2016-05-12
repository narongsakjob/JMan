import java.awt.Color;

public class Walker extends Piece{

	public Walker(int x,int y,int c, Map m) {
		super(Piece.WALKER, m);
		this.setX(x);
		this.setY(y);

		if(c==0) this.setColor(Color.RED);
		else if(c==1) this.setColor(Color.GREEN);
		else this.setColor(Color.YELLOW);

		// TODO Auto-generated constructor stub
	}

	public Walker(int x ,int y , Color c,Map m){
		super(Piece.WALKER, m);
		this.setX(x);
		this.setY(y);
		this.setColor(c);
	}

	
	public void act() {
		if(!hasActed()){
			int r = rand(1,12);
			if(r<9){
				setActed(true);
			}else {
				if(r==9){
					if(getMap().isEmpty(getX()-1, getY())){
						getMap().move(getX(), getY(), getX()-1, getY());
						
					}
				}else if(r==10){
					if(getMap().isEmpty(getX(), getY()-1)){
						getMap().move(getX(), getY(), getX(), getY()-1);
						
					}
				}else if(r==11){
					if(getMap().isEmpty(getX()+1, getY())){
						getMap().move(getX(), getY(), getX()+1, getY());
						
					}
				}else if(getMap().isEmpty(getX(), getY()+1)){
					getMap().move(getX(), getY(), getX(), getY()+1);
					
				}
				setActed(true);
			}


		}
	}
}


