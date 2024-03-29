package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import uitl.GameUtil;

import frame.MainFrame;

/**
 * 敌方子弹类
 * @author Administrator
 *
 */
public class EnemyBullet extends Bullet{
	
	public EnemyBullet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnemyBullet(int x, int y, int noun, int speed) {
		super(x, y, noun, speed);
	}
	private boolean indexof=true;
	//1为上 2为下 3为左 4为右
	public boolean shell(Graphics g) {
		switch (this.getNoun()) {
		case 1:
			if (this.getY() > 0) {
				int y = this.getY();
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
			}else
				indexof=false;
			break;
		}
		Color c=g.getColor();
		g.setColor(Color.yellow);
		if(MainFrame.mytank.getRect().intersects(this.getRect())){
			MainFrame.mytank.live=false;
			indexof=false;
			for(int i=1;i<=16;i++){
				Image img=GameUtil.getImage("image/explode/e"+i+".gif");
				g.drawImage(img,MainFrame.mytank.getX(),MainFrame.mytank.getY(),null);
			}
		}else{
			g.fillOval(this.getX(),this.getY(), 10, 10);
		}
		
		g.setColor(c);
		return indexof;
	}
}
