package software.java0911;
import java.util.Random;
import java.lang.Math;
import java.util.Scanner;
public class testmain {
	
	public static void lab01() {
		//import java.util.Random;
		//-2123123312~ 214743647 숫자 하나반환
		Random r =new Random();
		//int com =Math.abs(r.nextInt()%3)+1;
		int com,user;
		char a;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("가위 바위 보 중에 선택 하세요(가위 :1, 바위 :2 ,보 : 3) : ");
			user = scanner.nextInt();
			com = r.nextInt(3)+1;
			System.out.println("컴퓨터("+com+"),사용자("+user+")");
			if(user ==com )
				System.out.println("비겼습니다.\n");
			else
				switch(user -com) {
				case -2:
				case 1:
					System.out.println("이겼습니다 \n");
					break;
				case 2:
				case -1:
					System.out.println("졌습니다 \n");
					break;
					
				}
			System.out.println("종료 하시겠습니까?(종료 :n) :");
			String str1 =scanner.next();
			a = str1.charAt(0);
		}while(a != 'n');  //string을 사용했을 경우 answer.equals("no") 문자열 비교 
	}
	public static void lab02() {
		String password ="greenjoa";
		String input;
		Scanner scanner = new Scanner(System.in);
		for(int i = 0 ; i < 3; i++) {
			System.out.println("비밀 번호를 입력하세요");
			input = scanner.next();
			if(input.equals(password)) {
				System.out.println("환영합니다.\n");
				break;
			}
			else
				System.out.println("틀린 암호 입니다\n"+(i+1)+"번째 틀렸습니다. (3번 틀릴경우 종료)" );
			if(i == 2)
				System.out.println("접속을 거부 합니다.");	
		}
	}
	public static void lab03() 
	{
		String input;
		int leng;
		Scanner scanner = new Scanner(System.in);
		System.out.println("한 줄의 문장을 입력하세요 : ");
		input = scanner.nextLine();
		leng =input.length();
		for(int i=0 ; i < leng ; i++) {
			char a = input.charAt(i);
			if(a == '\t' || a==' ')
				leng--;
		}
		System.out.println("글자들의 수: " + leng);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 조윤직");
		lab03();
	}

}

