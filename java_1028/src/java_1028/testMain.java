package java_1028;

import java.util.Scanner;

public class testMain {
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("JAVA 수업 5조");
		Home home=new Home();
		while(true) {
			System.out.println("1. 집들어가기 2.IOT");
			int n= scan.nextInt();
			if(n==1) {
				home.open();
			}
			else
				home.connect();
		}
	}

}
