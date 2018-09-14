package MyShoot.Shoot;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ShootGame extends JPanel {
	public static final int WIDTH = 400;
	public static final int HEIGHT = 654;
	public static BufferedImage background ;
	public static BufferedImage start;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	static{

		try{
			background = ImageIO.read((ShootGame.class.getResourceAsStream("background.png")));
			start = ImageIO.read((ShootGame.class.getResourceAsStream("start.png")));
			pause = ImageIO.read((ShootGame.class.getResourceAsStream("pause.png")));
			gameover = ImageIO.read((ShootGame.class.getResourceAsStream("gameover.png")));
			airplane = ImageIO.read((ShootGame.class.getResourceAsStream("airplane.png")));
			bee = ImageIO.read((ShootGame.class.getResourceAsStream("bee.png")));
			bullet = ImageIO.read((ShootGame.class.getResourceAsStream("bullet.png")));
			hero0 = ImageIO.read((ShootGame.class.getResourceAsStream("hero0.png")));
			hero1 = ImageIO.read((ShootGame.class.getResourceAsStream("hero1.png")));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private Hero hero = new Hero();
	private FlyingObject[] flyings = {};
	private Bullet[] bullets ={};
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	private int state = START;
	
	public FlyingObject nextOne(){
		Random d  = new Random();
		int type = d.nextInt(20);
		if (type<4) {
			return new Bee();
		} else {
			return new Airplane();
		}
	}
	int flyEnterIndex = 0;
	public void enterAction(){
		flyEnterIndex++;
		if (flyEnterIndex%40==0) {
			FlyingObject obj = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length+1);
			flyings[flyings.length-1] = obj;
		}
	}
	public void stepAction() {
		hero.step();
		for (FlyingObject flyings : flyings) {
			flyings.step();
		}
		for (Bullet bullet : bullets) {
			bullet.step(); 
		}

	}
	int shootIndex = 0;
	public void shootAction(){
		shootIndex++;
		if(shootIndex%3==0){
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}
	public void outOfBoundsAction() {
		int index = 0;
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];
		for (FlyingObject flyingObject : flyings) {
			if (!flyingObject.outOfBounds()) {
				flyingLives[index] = flyingObject;
				index++;
			}
		}
		flyings = Arrays.copyOf(flyingLives,index); 
		index = 0;
		Bullet[] bulletLives  = new Bullet[bullets.length];
		for (Bullet bullet : bullets) {
			if (!bullet.outOfBounds()) {
				bulletLives[index] = bullet;
				index++;
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);
	}
	public void bangAction(){
		for (Bullet bullet : bullets) {
			bang(bullet);
		}
	}
	int score = 0;
	public void bang(Bullet b){
		int index = -1;
		for (int i = 0; i < flyings.length; i++) {
			FlyingObject f = flyings[i];
			if (f.shootBy(b)) {
				index = i;
				break;
			}
		}
		if (index!=-1) {
			FlyingObject one = flyings[index];
			if (one instanceof Enemy) {
				Enemy e = (Enemy)one;
				score += e.getScore();
			}
			if (one instanceof Award) {
				Award a = (Award)one;
				int type = a.getType();
				switch(type){
				case Award.LIFE:
					hero.addLife();
					break;
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire();
					break;
				}
			}
			FlyingObject t =flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = t;
			flyings = Arrays.copyOf(flyings, flyings.length-1);
		}
		
	}
	public void hitAction(){
		int index = 0;
		for (FlyingObject f : flyings) {
			index++;
			if (hero.hit(f)) {
				hero.subtractLife();
				hero.clearDoubleFire();
				FlyingObject one = f;
				f = flyings[flyings.length-1];
				flyings[flyings.length-1] = one;
				flyings = Arrays.copyOf(flyings, flyings.length-1);
				
			}
		}
	}
	public void checkGameOverAction() {
		if (hero.getLife()<=0) {
			state=GAME_OVER;
		}

	}
	public void action(){
		MouseAdapter l = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (state==RUNNING) {
				hero.moveTo(e.getX(), e.getY());
				}
			}
			public void mouseClicked(MouseEvent e) {
				switch (state) {
				case START:
					state=RUNNING;
					break;
				case GAME_OVER:
					score = 0;
					hero = new Hero();
					flyings = new FlyingObject[]{};
					bullets = new Bullet[]{};
					state=START;
					break;
				}
			}
			public void mouseExited(MouseEvent e) {
				if (state==RUNNING) {
					state = PAUSE;
				}
			}
			public void mouseEntered(MouseEvent e) {
				if (state==PAUSE) {
					state=RUNNING;
				}
			}
		};
		this.addMouseListener(l);//处理鼠标操作时间
		this.addMouseMotionListener(l);//处理鼠标滑动时间
		Timer timer = new Timer();
		int intervel = 10;//时间间隔
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (state==RUNNING) {
				stepAction();
				enterAction();//敌人入场
				shootAction();//子弹入场
				outOfBoundsAction();
				bangAction();//子弹与敌人碰撞检测
				hitAction();
				checkGameOverAction();
				}
				repaint();
			}
		}, intervel, intervel);
	}
	//重写paint()g：画笔
	public void paint(Graphics g){
		g.drawImage(background,0, 0, null);
		paintHero(g);
		paintFlyingObjects(g);
		paintBullets(g);
		paintScoreAndLife(g);
		paintState(g);
	} 
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x, hero.y, null);
	}
	public void paintFlyingObjects(Graphics g){
		for(int i = 0;i<flyings.length;i++){
			FlyingObject f = flyings[i];
			if (f.y>ShootGame.HEIGHT) {
				f = null;
			}else{
			g.drawImage(f.image, f.x, f.y, null);
			}
		}
	}
	public void paintBullets(Graphics g){
		for (Bullet bullet : bullets) {
			Bullet b=bullet;
			if (b.y<0) {
				b=null;
			}else{
			g.drawImage(b.image, b.x, b.y, null);
			}
		}
	}
	public void paintScoreAndLife(Graphics g){
		g.setColor(new Color(0xFF0000));
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 30));;
		g.drawString("SCORE:"+score, 10, 25);
		g.drawString("LIFE :"+hero.getLife(), 10, 55);
	}
	public void paintState(Graphics g){
		switch(state){
		case START:
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly");
		ShootGame game = new ShootGame();
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.action();
	}

}


















