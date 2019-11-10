package java_1028;

import java.util.Scanner;

public class refr extends HomeAppliance {
	public static Scanner scan=new Scanner(System.in);
	private double temp;
	private String HAName="냉장고";
	
	private boolean HaPower=true;
	@Override
	public void showStatus() {
		// TODO Auto-generated method stub
		System.out.println("냉장고의 지금 온도는 "+temp+"입니다.");
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		showStatus();
		System.out.println("바꾸실 냉장고의 온도를 입력하세요. : ");
		double tt=scan.nextDouble();
		temp=tt;
		showStatus();
		
	}

}
