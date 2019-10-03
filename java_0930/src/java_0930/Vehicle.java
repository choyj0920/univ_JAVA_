package java_0930;

public class Vehicle {
	String color;
	int speed = 0;
	char gearStatus = 'P';
	
	Vehicle(){
		this("������");
	}
	Vehicle(String color){
		this.color = color;
	}
	
	public void accelerate(int s) {
		this.speed +=s;
		System.out.println(s+"��ŭ �ӵ� ����, ���� �ӵ� : "+speed);
	}
	public void break_(int b) {
		this.speed -=b;
		System.out.println(b+"��ŭ �ӵ� ����, ���� �ӵ� : "+speed);
	}
	public void move() {
		if(speed != 0)
			System.out.println(color+"�� �ڵ��� "+ gearStatus + "���·� "+speed+"�ӵ� ������");
		else
			System.out.println(color+"�� �ڵ��� ���� ��");
	}
	public void changeGear(char g) {
		this.gearStatus =g;
		System.out.println("������ �ٲߴϴ�,���� ���� ��� : "+gearStatus);
	}
}
