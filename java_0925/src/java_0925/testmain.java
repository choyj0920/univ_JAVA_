package java_0925;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Math;
import java.lang.String;
import java.util.Scanner;
import java.io.File;
import java_0925.TV;

public class testmain {
	static Scanner scan =new Scanner(System.in);
	
	public static void lab01() {
		TV tv= new TV();
		tv.ShowStatus();
		tv.channelUp();
		tv.channelUp();
		tv.powerOnOff();
		tv.channelDown();
		
		TV tv2 =new TV();
		tv2.ShowStatus();
		
		tv2.volumeUp();
		tv2.volumeDown();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 Á¶À±Á÷");
		lab01();
	}

}
