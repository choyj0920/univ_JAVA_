package java_1030;

import java.util.Timer;
import java.util.TimerTask;
import java.lang.Thread;
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 ������");
		Outer out=new Outer();
		Outer.Inner1 i=out.new Inner1();
		
		View view =new View();
		Button btn=new Button();
		btn.setOnclickInterface(view);
		btn.onTouch();
		Button btn2=new Button();
		Button.onClickInterface click =new Button.onClickInterface() {
			@Override
			public void onClick() {//�̰��� ���� click �� ��ü �ϳ������� ����Ҽ� �ִ�.
				// TODO Auto-generated method stub
				System.out.println("��");
			}
		};
		btn2.setOnclickInterface(click);
		btn2.onTouch();
		
		TimerTask task = new TimerTask() {//�߻� Ŭ���� �̹Ƿ� �߻�޼ҵ带 ���� �ؾ���
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Bluejoa!");
				
			}
		};
		Timer timer =new Timer();
		//timer.schedule(task, 5000);
		timer.schedule(task, 1000,1000);
		Thread thread =new Thread() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("greenjoa"+i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				}
			}
		};
		thread.start();

		for(int i1=0;i1<10;i1++) {
			System.out.println("ȫ�浿"+i1);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		timer.cancel();
	}

}
