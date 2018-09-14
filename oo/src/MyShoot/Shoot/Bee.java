package MyShoot.Shoot;

import java.util.Random;

public class Bee extends FlyingObject implements Award{
	private int xSpeed = 3;
	private int ySpeed = 3;	
	private int awardType;
	public Bee() {
		image = ShootGame.bee;
		width = image.getWidth();
		height = image.getHeight();
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH-this.width);
		y = -this.height;
		awardType = rand.nextInt(2);
	}
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return awardType;
	}
	@Override
	public void step() {
		x+= xSpeed;
		y+=ySpeed;
		if (x>ShootGame.WIDTH-this.width) {
			xSpeed = -1;
		}
		if (x<=0) {
			xSpeed = 1;
		}
	}
	public boolean outOfBounds() {
		return this.y>=ShootGame.HEIGHT;
	}
	

}










