package uitl;

import java.util.Scanner;

public class Test {

	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Test t = new Test();
		t.setA(3);
		new Thread(new Runnable() {

			public void run() {
				while (t.getA() == 3) {
					System.out.println(t.getA());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			public void run() {
				try {
					Thread.sleep(5000);
					t.setA(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}
