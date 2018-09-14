package MyShoot.day01;

public class Shoot {

}
class Airplane extends FlyingObject implements Enemy{
	int width;
	int height;
	public Airplane(int x,int y,int w,int h) {
		this.x =x;
		this.y = y;
		width = w;
		height = h;
		
	}
	@Override
	public int getScore() {
		
		return 5;
	}

	@Override
	boolean shootBy(int x, int y) {
		int dx = x-this.x;
		int dy = y-this.y;
		return (dx>0&&dx<width)&&(dy>0&&dy<height);
	}
	
}
class Bee extends FlyingObject implements Award{
	int r;
	int type;
	public Bee(int x,int y,int r) {
		this.x = x;
		this.y = y;
		this.r = r;
		type = Award.DOUBLE_FIRE;
	}
	@Override
	boolean shootBy(int x, int y) {
		int a = x-this.x;
		int b = y - this.y;
		return Math.sqrt(a*a+b*b)<r;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return type;
	}
	
}
abstract class FlyingObject{
	int x;
	int y;
	abstract boolean shootBy(int x,int y);
}
interface Enemy{
	int getScore();
}
interface Award{
	int DOUBLE_FIRE = 2;//双倍火力
	int BOMB  = 1;//手雷
	int getType();//获取奖励类型返回值是整数
	
}
















