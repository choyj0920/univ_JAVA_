package java_1028;

import java.lang.ref.Cleaner;
import java.util.Scanner;

public class Home {
	private HomeAppliance HA[]= {new refr(),new TV(),new cleaner(),new boiler()};
	
	static Scanner scan= new Scanner(System.in);
	
	public void open() {
		System.out.println("���� ���� ���Խ��ϴ�.");
		System.out.println("��� ��⸦ �����ϽǼ� �ֽ��ϴ�. � ��⸦ �����ұ�� \n0.����� 1.TV 2.û�ұ� 3.���Ϸ�");
		Remote remotecontrol= new Remote();
		remotecontrol.setHA(HA[scan.nextInt()]);
		remotecontrol.onTouch();
	}
	public void connect() {
		IoTinterface II[]={(cleaner)HA[2],(boiler)HA[3]};
		System.out.println("���� ����");
		System.out.println("û�ұ�� ���Ϸ��� �����ϽǼ� �ֽ��ϴ�. � ��⸦ �����ұ�� \n2.û�ұ� 3.���Ϸ�");
		int n=scan.nextInt();
		if(HA[n] instanceof IoTinterface) {
			HA[n].showStatus();
			System.out.println("������ ų��� �����?");
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
