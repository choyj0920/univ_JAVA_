package java_0930;
import java.util.Scanner;
import java_0930.TV;
import java_0930.Vehicle;
import java_0930.CarUser;
public class TestMain {

	static Scanner scan =new Scanner(System.in);
	
	public static void lab01() {
		TV tele =new TV(12,20);
		
		tele.powerOnOff();
		tele.ShowStatus();
		
		TV tee =new TV(20);
		tee.powerOnOff();
		tee.ShowStatus();
	}
	public static void lab02() {
		Vehicle car1 =new Vehicle();
		car1.move();
		car1.accelerate(12);
		car1.move();
		car1.break_(5);
		car1.move();
	}
	public static void lab03() {
		Vehicle car1 =new Vehicle("ÆÄ¶û»ö");
		CarUser user1 =new CarUser("HY");
		user1.accelerate(car1, 12);
		user1.changeGear(car1, 'D');
		user1.move(car1);
	}
	
	public static void lab04() {
		Vehicle [] vehicles =new Vehicle[5];
		vehicles[0] =new Vehicle("»¡°­»ö");
		vehicles[1] =new Vehicle("ÆÄ¶û»ö");
		vehicles[2] =new Vehicle("³ë¶û»ö");
		vehicles[3] =new Vehicle("º¸¶ó»ö");
		
		CarUser user1 =new CarUser("HY");
		for(int i=0;i<4;i++) {
			user1.accelerate(vehicles[i], i+10);
			user1.move(vehicles[i]);
		}
		
	}
	
	public static void lab05() {
		int [] arr = {1,2,3,4,5};
		int [] copyarr =arr.clone();
		System.out.println("arr[3] = "+ arr[3]+"copyarr[3] = "+copyarr[3]);
		arr[3] +=1;
		System.out.println("arr[3] = "+ arr[3]+"copyarr[3] = "+copyarr[3]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 Á¶À±Á÷");
		lab05();
	}
}

