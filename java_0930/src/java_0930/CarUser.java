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
		System.out.println(name+"가 차를 가속합니다.");
		car.accelerate(s);
	}
	public void move(Vehicle car) {
		System.out.println(name+"가 차를 움직입니다.");
		car.move();
	}
	public void changeGear(Vehicle car,char g) {
		System.out.println(name+"가 기어를 바꿉니다");
		car.changeGear(g);
	}
}
