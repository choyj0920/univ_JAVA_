package java_0930;
import java_0930.Vehicle;
public class CarUser {
	String name;
	
	CarUser(){
		this("user");
	}
	CarUser(String name){
		this.name =name;
	}
	public void accelerate(Vehicle car,int s) {
		System.out.println(name+"�� ���� �����մϴ�.");
		car.accelerate(s);
	}
	public void move(Vehicle car) {
		System.out.println(name+"�� ���� �����Դϴ�.");
		car.move();
	}
	public void changeGear(Vehicle car,char g) {
		System.out.println(name+"�� �� �ٲߴϴ�");
		car.changeGear(g);
	}
}
