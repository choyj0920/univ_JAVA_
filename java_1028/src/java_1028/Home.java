package java_1028;

import java.lang.ref.Cleaner;
import java.util.Scanner;

public class Home {
	private HomeAppliance HA[]= {new refr(),new TV(),new cleaner(),new boiler()};
	
	static Scanner scan= new Scanner(System.in);
	
	public void open() {
		System.out.println("문을 열고 들어왔습니다.");
		System.out.println("모든 기기를 조작하실수 있습니다. 어떤 기기를 조작할까요 \n0.냉장고 1.TV 2.청소기 3.보일러");
		Remote remotecontrol= new Remote();
		remotecontrol.setHA(HA[scan.nextInt()]);
		remotecontrol.onTouch();
	}
	public void connect() {
		IoTinterface II[]={(cleaner)HA[2],(boiler)HA[3]};
		System.out.println("무선 연결");
		System.out.println("청소기와 보일러만 조작하실수 있습니다. 어떤 기기를 조작할까요 \n2.청소기 3.보일러");
		int n=scan.nextInt();
		if(HA[n] instanceof IoTinterface) {
			HA[n].showStatus();
			System.out.println("전원을 킬까요 끌까요?");
			if(scan.nextBoolean()) 
				II[n-2].turnOn();
			else
				II[n-2].turnOff();
			scan.nextLine();
		}
	}
	public Home() {
		
		// TODO Auto-generated constructor stub
	
	}
}
