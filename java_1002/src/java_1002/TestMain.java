package java_1002;
import java.util.Scanner;
import java.util.Random;
import java.lang.String;
import java_1002_2.BankAccount;

public class TestMain {
	public static Scanner scan =new Scanner(System.in);
	public static void lab01() {
		System.out.print("¹®ÀÚ¿­ ÀÔ·Â : ");
		String str = scan.nextLine();
		
		char[] str_ch = replaceChar(str,' ','%');
		System.out.println(str_ch);
		
		
	}
	public static void  replaceChar(char[] str,char a, char b) {
		for(int i=0 ; i< str.length;i++)
			if(str[i]==a)
				str[i]=b;
	}
	public static char[] replaceChar(String str,char a, char b) {
		
		char[] str_ch =str.toCharArray();
		replaceChar(str_ch,a,b);
		return str_ch;
	}
	public static void lab02() {
		String name ="greenjoa";
		String str = "x";
		str =str.replaceAll("x", "xxxxxxxxxx");
		str =str.replaceAll("x", "xxxxxxxxxx");
		str =str.replaceAll("x", name+"\n");
		System.out.println(str);
	}
	public static void lab03() {
		BankAccount bank1 = new BankAccount(100,"È«±æµ¿",1000);
		BankAccount bank2 = new BankAccount(200,"±è±æµ¿",500);
		bank1.deposit(1000);
		bank1.transfer(bank1, 500);
		System.out.println(bank1);
		System.out.println(bank2);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 Á¶À±Á÷");
		lab03();
	}

}
