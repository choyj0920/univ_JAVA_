package java_1028;

import java.util.Scanner;

public class boiler extends HomeAppliance  implements IoTinterface{
	public static Scanner scan=new Scanner(System.in);
	
	private String HAName="���Ϸ�";
	private boolean HaPower=false;
	private int temp=0;
	@Override
	public void showStatus() {
		// TODO Auto-generated method stub
		if(!HaPower) {
			System.out.println("���Ϸ��� �����ֽ��ϴ�.");
		}
		else
			System.out.println("���Ϸ��� �����ֽ��ϴ�. ���Ϸ��� �µ��� ���� "+temp+"�Դϴ�");
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		showStatus();
		if(!HaPower) {
			System.out.println("���Ϸ��� ���� �����ֽ��ϴ�. ���Ϸ��� ������ Ű�ðڽ��ϱ�?(boolean�Է�) ");
			if(scan.nextBoolean()) {
				turnOn();
				System.out.println("���Ϸ� �µ��� ��� �ұ��");
				temp=scan.nextInt();
			}
		
		}
		else {
			showStatus();
			System.out.println("���Ϸ� �µ��� ��� �ұ��");
			temp=scan.nextInt();
		}
		showStatus();
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		if(HaPower) {
			System.out.println("�̹� �����ֽ��ϴ�");
		}
		else {
			System.out.println("���Ϸ��� ŵ�ϴ�");
			HaPower=true;
		}
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		if(!HaPower) {
			System.out.println("�̹� �����ֽ��ϴ�");
		}
		else {
			System.out.println("���Ϸ��� ���ϴ�");
			HaPower=false;
		}
	}

}
