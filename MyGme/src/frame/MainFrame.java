package frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

import object.EnemyTank;
import object.MyTank;

import uitl.GameUtil;


public class MainFrame extends JFrame{
	MyTank mytank=null;
	static MainFrame main=null;
	public static void main(String[] args) {
		main=new MainFrame();
		
	}
	public MainFrame() {
		MyPanle mypenle=new MyPanle();
		mypenle.setBackground(Color.BLACK);
		mytank=new MyTank(460,720,1,5,0,0);
		this.addKeyListener(mytank);
		this.setTitle("̹坦克大战");
		this.setVisible(true);//显示界面
		this.add(mypenle);
		this.setBounds(300, 100, 1000, 800);
		this.setResizable(false);//大小不能改变
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口并释放资源
		
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
	class MyPanle extends JPanel{
		Image img=GameUtil.getImage("image/t_up.png");
		EnemyTank[] Etank=new EnemyTank[5];
		public MyPanle(){
			carEtank();
		}
		@Override
		public void paint(final Graphics g) {
			super.paint(g);
			mytank.speed(g);
			
			for(EnemyTank et:Etank){
				et.speed(g);
			}
		}
		//创建敌方坦克对象数组
		private void carEtank(){
			for(int i=0;i<Etank.length;i++){
				EnemyTank e=new EnemyTank();
				Etank[i]=e;
			}
		}
	}
}
