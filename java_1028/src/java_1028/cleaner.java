package java_1028;

import java.util.Scanner;

public class cleaner extends HomeAppliance implements IoTinterface {
	public static Scanner scan=new Scanner(System.in);
	private int segi;
	private String HAName="û�ұ�";
	private boolean HaPower=false;
	@Override
	public void showStatus() {
		// TODO Auto-generated method stub
		if(!HaPower) {
			System.out.println("û�ұ�� �����ֽ��ϴ�.");
		}
		else
			System.out.println("û�ұ�� �����ֽ��ϴ�. û�ұ��� ����� ���� "+segi+"�Դϴ�");
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		showStatus();
		if(!HaPower) {
			System.out.println("û�ұⰡ ���� �����ֽ��ϴ�. û�ұ��� ������ Ű�ðڽ��ϱ�?(boolean�Է�) ");
			if(scan.nextBoolean()) {
				turnOn();
				System.out.println("û�ұ� ���⸦ ��� �ұ��");
				segi=scan.nextInt();
			}
		
		}
		else {
			System.out.println("û�ұ� ���⸦ ��� �ұ��");
			segi=scan.nextInt();
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
			System.out.println("û�ұ⸦ ŵ�ϴ�");
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
			System.out.println("û�ұ⸦ ���ϴ�");
			HaPower=false;
		}
	}

}
