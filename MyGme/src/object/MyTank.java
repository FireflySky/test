package object;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import uitl.GameUtil;

/**
 * 用户操作的坦克类
 * 
 * @author Administrator
 * 
 */
public class MyTank extends Tank implements KeyListener {
	private boolean left = false;
	private boolean up = false;
	private boolean right = false;
	private boolean dow = false;
	private boolean bullet = false;
	static ArrayList<MyBullet> list = null;

	public MyTank(int x, int y, int noun, int speed, int width, int height) {
		super(x, y, noun, speed, width, height);
		list = new ArrayList<MyBullet>();
	}

	public MyTank() {
		super();
	}

	/**
	 * 坦克移动
	 * 
	 * @param g
	 */
	private Image img = null;
	private int countTime = 10;
	//坦克的移动
	public void speed(Graphics g) {
		spee(g);
		shel(g);
	}
	//发射子弹
	private void shel(Graphics g){
		// 发射子弹
				if (bullet) {
					if (countTime == 10) {
						MyBullet bull=null;
						//调整子弹发射位置
						switch (this.getNoun()) {
						case 1:
							 bull= new MyBullet(this.getX()+16, this.getY()-5,
									this.getNoun(), 7);
							break;
						case 2:
							bull= new MyBullet(this.getX()+18, this.getY()+38,
									this.getNoun(), 7);
							break;
						case 3:
							bull= new MyBullet(this.getX(), this.getY()+18,
									this.getNoun(), 7);
							break;
						case 4:
							bull= new MyBullet(this.getX()+38, this.getY()+18,
									this.getNoun(), 7);
							break;
						}
						
						bull.shell(g);
						list.add(bull);
						countTime = 0;
					} else
						countTime++;
				}
				//跟新所有发射的子弹位置
				for (int i = 0; i < list.size(); i++) {
					boolean result = list.get(i).shell(g);
					if (!result) {
						list.remove(i);
					}
				}
	}

	//坦克移动
	private void spee(Graphics g){
		if (!(left || up || right || dow)) {
			if (img == null) {
				img = GameUtil.getImage("image/t_up.png");
			} else
				g.drawImage(img, this.getX(), this.getY(), null);
		}
		if (left && this.getX() > 0) {
			int x = this.getX();
			x -= this.getSpeed();
			this.setX(x);
			this.setNoun(3);//移动方向
			img = GameUtil.getImage("image/t_left.png");
		} else if (right && this.getX() < 950) {
			int x = this.getX();
			x += this.getSpeed();
			this.setX(x);
			this.setNoun(4);
			img = GameUtil.getImage("image/t_right.png");
		} else if (up && this.getY() > 0) {
			int y = this.getY();
			y -= this.getSpeed();
			this.setY(y);
			this.setNoun(1);
			img = GameUtil.getImage("image/t_up.png");
		} else if (dow && this.getY() < 730) {
			int y = this.getY();
			y += this.getSpeed();
			this.setY(y);
			this.setNoun(2);
			img = GameUtil.getImage("image/t_dow.png");
		}
		g.drawImage(img, this.getX(), this.getY(), null);
		this.setWidth(img.getWidth(null));
		this.setHeight(img.getHeight(null));
	}
	
	// 键盘按下抬起事件
	public void keyTyped(KeyEvent e) {
		
	}

	// 键盘按下事件
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			up = true;
			break;
		case KeyEvent.VK_S:
			dow = true;
			break;
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_D:
			right = true;
			break;
		case KeyEvent.VK_J:
			bullet = true;
			break;
		}
	}

	// 键盘抬起事件
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			up = false;
			break;
		case KeyEvent.VK_S:
			dow = false;
			break;
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_D:
			right = false;
			break;
		case KeyEvent.VK_J:
			bullet = false;
			countTime=10;
			break;
		}
	}
}
