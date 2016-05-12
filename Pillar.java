import java.awt.Color;

public class Pillar extends Piece{

	public Pillar(int x,int y,int c, Map m) {
		super(3, m);
		this.setX(x);
		this.setY(y);

		if(c==0) this.setColor(Color.RED);
		else if(c==1) this.setColor(Color.GREEN);
		else this.setColor(Color.YELLOW);
		// TODO Auto-generated constructor stub
	}
	
	public Pillar(int x ,int y , Color c,Map m){
		super(3, m);
		this.setX(x);
		this.setY(y);
		this.setColor(c);
	}
	
	@Override
	public void act() {
		
		if(!this.hasActed()){
			int r = rand(1,9);
			if(r < 7){
				this.setActed(true);
			}else{
				if(r == 7){
					this.setColor(Color.RED);
				}else if(r==8){
					this.setColor(Color.GREEN);
				}else{
					this.setColor(Color.YELLOW);
				}
				this.setActed(true);
			}
		}
		
	}

}
