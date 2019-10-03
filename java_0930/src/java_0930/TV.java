package java_0930;

public class TV {
	public boolean power =false ;
	public int chanel; //¸â¹ö ÃÊ±âÈ­
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
			System.out.println("TV ÄÑÁü");
		else
			System.out.println("TV ²¨Áü");
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
		System.out.println("ÇöÀç TV Ã¤³Î : "+chanel+ " TV º¼·ý : "+volume);
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
