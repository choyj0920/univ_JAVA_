package software.java0911;
import java.util.Random;
import java.lang.Math;
import java.util.Scanner;
public class testmain {
	
	public static void lab01() {
		//import java.util.Random;
		//-2123123312~ 214743647 ���� �ϳ���ȯ
		Random r =new Random();
		//int com =Math.abs(r.nextInt()%3)+1;
		int com,user;
		char a;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("���� ���� �� �߿� ���� �ϼ���(���� :1, ���� :2 ,�� : 3) : ");
			user = scanner.nextInt();
			com = r.nextInt(3)+1;
			System.out.println("��ǻ��("+com+"),�����("+user+")");
			if(user ==com )
				System.out.println("�����ϴ�.\n");
			else
				switch(user -com) {
				case -2:
				case 1:
					System.out.println("�̰���ϴ� \n");
					break;
				case 2:
				case -1:
					System.out.println("�����ϴ� \n");
					break;
					
				}
			System.out.println("���� �Ͻðڽ��ϱ�?(���� :n) :");
			String str1 =scanner.next();
			a = str1.charAt(0);
		}while(a != 'n');  //string�� ������� ��� answer.equals("no") ���ڿ� �� 
	}
	public static void lab02() {
		String password ="greenjoa";
		String input;
		Scanner scanner = new Scanner(System.in);
		for(int i = 0 ; i < 3; i++) {
			System.out.println("��� ��ȣ�� �Է��ϼ���");
			input = scanner.next();
			if(input.equals(password)) {
				System.out.println("ȯ���մϴ�.\n");
				break;
			}
			else
				System.out.println("Ʋ�� ��ȣ �Դϴ�\n"+(i+1)+"��° Ʋ�Ƚ��ϴ�. (3�� Ʋ����� ����)" );
			if(i == 2)
				System.out.println("������ �ź� �մϴ�.");	
		}
	}
	public static void lab03() 
	{
		String input;
		int leng;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�� ���� ������ �Է��ϼ��� : ");
		input = scanner.nextLine();
		leng =input.length();
		for(int i=0 ; i < leng ; i++) {
			char a = input.charAt(i);
			if(a == '\t' || a==' ')
				leng--;
		}
		System.out.println("���ڵ��� ��: " + leng);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 ������");
		lab03();
	}

}

