package object;

import java.awt.Graphics;
import java.awt.Image;

import uitl.GameUtil;

/**
 * 草坪背景类
 * @author Administrator
 *
 */
public class BackLawn extends Background {
	Image img=null;
	private int imgx;
	private int imgy;
	public BackLawn(int x, int y, int width, int height) {
		super(x, y, width, height);
		img=GameUtil.getImage("image/btn3.png");
		this.setHeight(img.getHeight(null));
		this.setWidth(img.getWidth(null));
		
	}
	public void pen(Graphics g){
		imgy=300;
		imgx=100;
		for(int i=0;i<4;i++){
			for(int j=0;j<20;j++){
				g.drawImage(this.img,this.imgx,this.imgy,null);
				this.imgx+=40;
			}
			imgx=100;
			this.imgy+=50;
		}
	}
}
