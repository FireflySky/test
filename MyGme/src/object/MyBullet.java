package object;

import java.awt.Color;
import java.awt.Graphics;

import uitl.GameUtil;

public class MyBullet extends Bullet {

	public MyBullet(int x, int y, int noun, int speed) {
		super(x, y, noun, speed);
	}

	public MyBullet() {
		super();
	}
	private boolean indexof=true;
	//1为上 2为下 3为左 4为右
	public boolean shell(Graphics g) {
		System.out.println(this.getNoun());
		switch (this.getNoun()) {
		case 1:
			if (this.getY() > 0) {
				int y = this.getY();
				System.out.println(y);
				y -= this.getSpeed();
				this.setY(y);
			}else
				indexof=false;
			break;
		case 2:
			if (this.getY() < 800) {
				int y = this.getY();
				y += this.getSpeed();
				this.setY(y);
			}else
				indexof=false;
			break;
		case 3:
			if (this.getX() > 0) {
				int x = this.getX();
				x -= this.getSpeed();
				this.setX(x);
			}else
				indexof=false;
			break;
		case 4:
			if (this.getX() < 1000) {
				int x = this.getX();
				x += this.getSpeed();
				this.setX(x);
				System.out.println(x);
			}else
				indexof=false;
			break;
		}
		Color c=g.getColor();
		g.setColor(Color.white);
		g.fillOval(this.getX(),this.getY(), 10, 10);
		g.setColor(c);
		return indexof;
	}
}
