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
		System.out.println("지금 TV의 채널은 "+channel+"볼륨은 "+vol);
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		showStatus();
		System.out.println("1. tv의 채널조정  2. tv의 볼륨 조정");
		int tt=scan.nextInt();
		if(tt ==1) {
			System.out.println("변경할 tv채널을 입력하세요");
			tt=scan.nextInt();
			channel=tt;
		}
		else {
			System.out.println("변경할 tv볼륨을 입력하세요");
			tt=scan.nextInt();
			channel=tt;
		}
		showStatus();
	}

}
