package java_0930;

public class TV {
	public boolean power =false ;
	public int chanel; //��� �ʱ�ȭ
	public int volume;
	TV() {
		this(10,10);
	}
	TV(int channel,int Volume) {
		this.chanel =channel;
		this.volume =Volume;
	}
	TV(int channel) {
		this(channel,10);
	}
	
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
