package object;

import java.awt.Rectangle;

/**
 * 坦克类
 * 
 * @author Administrator
 * 
 */
public class Tank {
	private int x;
	private int y;
	private int width;
	private int height;
	private int noun;// 方向
	private int speed;// 移动速度

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getNoun() {
		return noun;
	}

	public void setNoun(int noun) {
		this.noun = noun;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Tank(int x, int y, int noun, int speed,int width,int height) {
		super();
		this.x = x;
		this.y = y;
		this.noun = noun;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	public Tank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public  Rectangle   getRect(){
		return  new Rectangle((int)x, (int)y, width, height);
	}
}
