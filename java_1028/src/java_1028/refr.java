package java_1028;

import java.util.Scanner;

public class refr extends HomeAppliance {
	public static Scanner scan=new Scanner(System.in);
	private double temp;
	private String HAName="�����";
	
	private boolean HaPower=true;
	@Override
	public void showStatus() {
		// TODO Auto-generated method stub
		System.out.println("������� ���� �µ��� "+temp+"�Դϴ�.");
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		showStatus();
		System.out.println("�ٲٽ� ������� �µ��� �Է��ϼ���. : ");
		double tt=scan.nextDouble();
		temp=tt;
		showStatus();
		
	}

}
