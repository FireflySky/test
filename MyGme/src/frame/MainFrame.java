package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import object.BackLawn;
import object.EnemyBullet;
import object.EnemyTank;
import object.MyTank;

import uitl.GameUtil;


public class MainFrame extends JFrame{
	public static MyTank mytank=null;
	public static MyPanle mypenle=null;
	static MainFrame main=null;
	private BackLawn laown=null;
	public static void main(String[] args) {
		main=new MainFrame();
		
	}

	public MainFrame() {
		mypenle=new MyPanle();
		mypenle.setBackground(Color.BLACK);
		mytank=new MyTank(460,720,1,5,0,0);
		laown=new BackLawn(50, 300, 0, 0);
		this.addKeyListener(mytank);
		this.setTitle("̹坦克大战");
		this.setVisible(true);//显示界面
		this.add(mypenle);
		this.setBounds(300, 100, 1000, 800);
		this.setResizable(false);//大小不能改变
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口并释放资源
		
		//更新屏幕线程
		new Thread(new Runnable() {
			public void run() {
				try {
					while (true) {
						repaint();
						Thread.sleep(40);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}
	public class MyPanle extends JPanel{
		Image img=GameUtil.getImage("image/t_up.png");
		public ArrayList<EnemyTank> Etank=new ArrayList<EnemyTank>();
		public MyPanle(){
			carEtank();
		}
		@Override
		public void paint(final Graphics g) {
			super.paint(g);
			
			laown.pen(g);//画草坪背景
			if(mytank.live){
			mytank.speed(g);
			}else{
				//死亡
				g.setColor(Color.red);
				Font f=new Font("华文彩云",Font.BOLD,50);
				g.setFont(f);
				g.drawString("游戏失败", 300, 400);
			}
			if(Etank.size()!=0){
			for(int i=0;i<Etank.size();i++){
				if(Etank.get(i).live){
					Etank.get(i).speed(g);
				}else{
					Etank.remove(i);
				}
			}
			}else{
				g.setColor(Color.red);
				Font f=new Font("华文彩云",Font.BOLD,50);
				g.setFont(f);
				g.drawString("恭喜你，获得胜利", 300, 400);
			}
		}
		//创建敌方坦克对象数组
		private void carEtank(){
			for(int i=0;i<10;i++){
				EnemyTank e=new EnemyTank();
				Etank.add(e);
			}
		}
	}
}
