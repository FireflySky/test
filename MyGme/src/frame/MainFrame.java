package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	JPanel pan=null;
	public static void main(String[] args) {
		MainFrame main=new MainFrame();
		
	}
	public MainFrame() {
		this.setTitle("̹坦克大战");
		this.setVisible(true);//显示界面
		this.setBounds(100, 100, 300, 200);
		this.setResizable(false);//大小不能改变
	}
	private void plane(){
		new JPanel();
	}
}
