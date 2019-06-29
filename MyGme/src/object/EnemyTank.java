package object;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import uitl.GameUtil;

/**
 * 敌人坦克
 * 
 * @author Administrator
 * 
 */
public class EnemyTank extends Tank {
	private int countTime = 0;// 隔20*40毫秒发射一次子弹
	private int count = 70;// 30*40毫秒改变一次移动方向
	private ArrayList<EnemyBullet> list = null;

	public ArrayList<EnemyBullet> getList() {
		return list;
	}

	public void setList(ArrayList<EnemyBullet> list) {
		this.list = list;
	}

	public EnemyTank() {
		super();
		list = new ArrayList<EnemyBullet>();
		this.setNoun(2);
		this.setSpeed(5);
		this.setWidth(0);
		this.setHeight(0);
		randomXy();
	}

	private Image img = null;

	public void speed(Graphics g) {
		nonu(g);
		// 发射子弹
		int q=shell();
		if (q < 3) {
			if (countTime == 20) {
				EnemyBullet bull = null;
				// 调整子弹发射位置
				switch (this.getNoun()) {
				case 1:
					bull = new EnemyBullet(this.getX() + 16, this.getY() - 5,
							this.getNoun(), 7);
					break;
				case 2:
					bull = new EnemyBullet(this.getX() + 18, this.getY() + 38,
							this.getNoun(), 7);
					break;
				case 3:
					bull = new EnemyBullet(this.getX(), this.getY() + 18,
							this.getNoun(), 7);
					break;
				case 4:
					bull = new EnemyBullet(this.getX() + 38, this.getY() + 18,
							this.getNoun(), 7);
					break;
				}
				bull.shell(g);
				this.list.add(bull);
				countTime = 0;
			}
			countTime++;
		}
		

		// 跟新所有发射的子弹位置 移除超出屏幕的子弹
			for (int i = 0; i < this.list.size(); i++) {
				boolean result = list.get(i).shell(g);
				if (!result) {
					list.remove(i);
				}
			}
	}

	int i = 0;

	// 确定移动方向
	private void nonu(Graphics g) {

		if (count == 100) {
			i = speedRandmo();
			count = 0;
		}
		count++;
		// 默认方向朝下
		if (img == null) {
			img = GameUtil.getImage("image/d_dow.png");
		} 
		up();
		dow();
		left();
		right();
		g.drawImage(img, this.getX(), this.getY(), null);
		this.setWidth(img.getWidth(null));
		this.setHeight(img.getHeight(null));
	}

	//向上移动
	private void up(){
		if (i>50 && i <= 75) {
			if(this.getY() < 0){//向上无法移动后向右移
				i=30;
				return;
			}
			int y = this.getY();
			y -= this.getSpeed();
			this.setY(y);
			this.setNoun(1);
			img = GameUtil.getImage("image/d_up.png");
		}
	}
	//向下移动
	private void dow(){
		if (i>75) {
			if(this.getY() > 730){//向下无法移动后向左移
				i=10;
				return;
			}
			int y = this.getY();
			y += this.getSpeed();
			this.setY(y);
			this.setNoun(2);
			img = GameUtil.getImage("image/d_dow.png");
		}
	}
	//向左移动
	private void left(){
		if (i <= 25) {
			if(this.getX() < 0){
				i=60;
				return;
			}
			int x = this.getX();
			x -= this.getSpeed();
			this.setX(x);
			this.setNoun(3);// 移动方向
			img = GameUtil.getImage("image/d_left.png");
		}
	}
	//向右移动
	private void right(){
		if (i>25 && i <= 50) {
			if(this.getX() > 950){
				i=80;
				return;
			}
			int x = this.getX();
			x += this.getSpeed();
			this.setX(x);
			this.setNoun(4);
			img = GameUtil.getImage("image/d_right.png");
		}
	}
	// 产生发射的随机数
	private int shell() {
		return (int) (Math.random() * 10);
	}

	// 产生移动的随机数
	private int speedRandmo() {
		return (int) (Math.random() * 100);
	}

	// 产生出现地点的随机数
	private void randomXy() {
		this.setX((int) (Math.random() * 900) + 50);
		this.setY((int) (Math.random() * 600));
	}
}
