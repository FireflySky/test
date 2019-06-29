package object;
/**
 * 子弹类
 * @author Administrator
 *
 */
public class Bullet {
private int x;
private int y;
private int noun;
private int speed;
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
public Bullet(int x, int y, int noun, int speed) {
	super();
	this.x = x;
	this.y = y;
	this.noun = noun;
	this.speed = speed;
}
public Bullet() {
	super();
	// TODO Auto-generated constructor stub
}

}
