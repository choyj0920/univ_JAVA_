package java_1028;

import java.util.Scanner;

public class cleaner extends HomeAppliance implements IoTinterface {
	public static Scanner scan=new Scanner(System.in);
	private int segi;
	private String HAName="청소기";
	private boolean HaPower=false;
	@Override
	public void showStatus() {
		// TODO Auto-generated method stub
		if(!HaPower) {
			System.out.println("청소기는 꺼져있습니다.");
		}
		else
			System.out.println("청소기는 켜져있습니다. 청소기의 세기는 지금 "+segi+"입니다");
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		showStatus();
		if(!HaPower) {
			System.out.println("청소기가 지금 꺼져있습니다. 청소기의 전원을 키시겠습니까?(boolean입력) ");
			if(scan.nextBoolean()) {
				turnOn();
				System.out.println("청소기 세기를 어떻게 할까요");
				segi=scan.nextInt();
			}
		
		}
		else {
			System.out.println("청소기 세기를 어떻게 할까요");
			segi=scan.nextInt();
		}
		showStatus();
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		if(HaPower) {
			System.out.println("이미 켜져있습니다");
		}
		else {
			System.out.println("청소기를 킵니다");
			HaPower=true;
		}
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		if(!HaPower) {
			System.out.println("이미 꺼져있습니다");
		}
		else {
			System.out.println("청소기를 끕니다");
			HaPower=false;
		}
	}

}
