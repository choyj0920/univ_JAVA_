package java_0930;

public class Vehicle {
	String color;
	int speed = 0;
	char gearStatus = 'P';
	
	Vehicle(){
		this("검은색");
	}
	Vehicle(String color){
		this.color = color;
	}
	
	public void accelerate(int s) {
		this.speed +=s;
		System.out.println(s+"만큼 속도 증가, 지금 속도 : "+speed);
	}
	public void break_(int b) {
		this.speed -=b;
		System.out.println(b+"만큼 속도 감소, 지금 속도 : "+speed);
	}
	public void move() {
		if(speed != 0)
			System.out.println(color+"의 자동차 "+ gearStatus + "상태로 "+speed+"속도 운행중");
		else
			System.out.println(color+"의 자동차 정차 중");
	}
	public void changeGear(char g) {
		this.gearStatus =g;
		System.out.println("차량기어를 바꿉니다,현재 차량 기어 : "+gearStatus);
	}
}
