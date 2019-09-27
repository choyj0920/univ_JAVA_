package java_0925;

public class TV {
	public boolean power =true ;
	public int chanel =10 ; //¸â¹ö ÃÊ±âÈ­
	public int volume =10;
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
