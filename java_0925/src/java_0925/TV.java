package java_0925;

public class TV {
	public boolean power =true ;
	public int chanel =10 ; //��� �ʱ�ȭ
	public int volume =10;
	public void powerOnOff() {
		power =!power;
		if(power)
			System.out.println("TV ����");
		else
			System.out.println("TV ����");
	}
	public void channelUp() {
		if(power) {
			chanel++;
			ShowStatus();
		}
	
	}
	public void channelDown() {
		if(power) {
			chanel--;
			ShowStatus();
		}
	}
	public void ShowStatus() {
		if(power) {
		System.out.println("���� TV ä�� : "+chanel+ " TV ���� : "+volume);
		}
	}
	public void volumeUp() {
		if(power) {
			volume++;
			ShowStatus();
		}
	
	}
	public void volumeDown() {
		if(power) {
			volume--;
			ShowStatus();
		}
	}
}
