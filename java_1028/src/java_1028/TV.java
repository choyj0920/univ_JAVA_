package java_1028;

import java.util.Scanner;

public class TV extends HomeAppliance {
	public static Scanner scan=new Scanner(System.in);
	private int channel,vol;
	private String HAName="TV";
	private boolean HaPower=true;
	@Override
	public void showStatus() {
		// TODO Auto-generated method stub
		System.out.println("���� TV�� ä���� "+channel+"������ "+vol);
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		showStatus();
		System.out.println("1. tv�� ä������  2. tv�� ���� ����");
		int tt=scan.nextInt();
		if(tt ==1) {
			System.out.println("������ tvä���� �Է��ϼ���");
			tt=scan.nextInt();
			channel=tt;
		}
		else {
			System.out.println("������ tv������ �Է��ϼ���");
			tt=scan.nextInt();
			channel=tt;
		}
		showStatus();
	}

}
