package java_1028;

import java.util.Scanner;

public class boiler extends HomeAppliance  implements IoTinterface{
	public static Scanner scan=new Scanner(System.in);
	
	private String HAName="보일러";
	private boolean HaPower=false;
	private int temp=0;
	@Override
	public void showStatus() {
		// TODO Auto-generated method stub
		if(!HaPower) {
			System.out.println("보일러는 꺼져있습니다.");
		}
		else
			System.out.println("보일러는 켜져있습니다. 보일러의 온도는 지금 "+temp+"입니다");
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		showStatus();
		if(!HaPower) {
			System.out.println("보일러가 지금 꺼져있습니다. 보일러의 전원을 키시겠습니까?(boolean입력) ");
			if(scan.nextBoolean()) {
				turnOn();
				System.out.println("보일러 온도를 어떻게 할까요");
				temp=scan.nextInt();
			}
		
		}
		else {
			showStatus();
			System.out.println("보일러 온도를 어떻게 할까요");
			temp=scan.nextInt();
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
			System.out.println("보일러를 킵니다");
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
			System.out.println("보일러를 끕니다");
			HaPower=false;
		}
	}

}
