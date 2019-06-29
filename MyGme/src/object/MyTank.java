package object;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

	public MyTank(int x, int y, int noun, int speed, int width, int height) {
		super(x, y, noun, speed, width, height);
	}

	public MyTank() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 坦克移动
	 * 
	 * @param g
	 */
	Image img = null;

	public void speed(Graphics g) {

		if (!(left || up || right || dow)) {
			if (img == null) {
				img = GameUtil.getImage("image/t_up.png");
			} else
				g.drawImage(img, this.getX(), this.getY(), null);
		}
		if (left) {
			int x = this.getX();
			x -= this.getSpeed();
			this.setX(x);
			img = GameUtil.getImage("image/t_left.png");
			g.drawImage(GameUtil.getImage("image/t_left.png"), this.getX(),
					this.getY(), null);
		} else if (right) {
			int x = this.getX();
			x += this.getSpeed();
			this.setX(x);
			img = GameUtil.getImage("image/t_right.png");
			g.drawImage(GameUtil.getImage("image/t_right.png"), this.getX(),
					this.getY(), null);
		} else if (up) {
			int y = this.getY();
			y -= this.getSpeed();
			this.setY(y);
			img = GameUtil.getImage("image/t_up.png");
			g.drawImage(GameUtil.getImage("image/t_up.png"), this.getX(),
					this.getY(), null);
		} else if (dow) {
			int y = this.getY();
			y += this.getSpeed();
			this.setY(y);
			img = GameUtil.getImage("image/t_dow.png");
			g.drawImage(GameUtil.getImage("image/t_dow.png"), this.getX(),
					this.getY(), null);
		}
		this.setWidth(img.getWidth(null));
		this.setHeight(img.getHeight(null));
	}

	// 键盘按下抬起事件
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

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
		}
	}
}
