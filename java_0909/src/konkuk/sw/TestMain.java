//package konkuk.sw;
//import java.util.Scanner;
//public class TestMain {
//
//	public static void lab01() {
//		System.out.println("첫번째 실습");
////		int a =65;
////		System.out.println((char)a);
////		System.out.printf("%c\n",a);
//		System.out.println("학번 이름 나이 주소를 공백으로 띄어서 입력 하세요.");
//		Scanner scanner = new Scanner(System.in);
//		String stu_num = scanner.next();
//		String stu_name = scanner.next();
//		int stu_age = scanner.nextInt();
//		//nextline은 이전에 엔터를 입력 받았을 경우 입력을 받지않고 끝나버리기 때문에 엔터를 한번 빼주어야함 scanner.next();		
//		String stu_adr = scanner.nextLine();
//		System.out.println("학번 : "+stu_num);
//		System.out.println("이름 : "+stu_name);
//		System.out.println("나이 : "+stu_age);
//		System.out.println("주소 : "+stu_adr);
//		
//	}
//	public static void lab02() {
//		System.out.println("두번째 실습");
//		int rgb = 0xffffff00; //두개씩 알파레드그린블루 (255,255,255,0) =>노란색
//		String strrgb =Integer.toBinaryString(rgb);
//		System.out.println("현재 색상 : " +strrgb);
//		int rgb2 = 0xffff00ff;
//		strrgb =Integer.toBinaryString(rgb & rgb2);
//		System.out.println("변경 색상 : " +strrgb);
//	}
//	public static void lab03() {
//		Scanner scan = new Scanner(System.in);
//		String str1 =scan.next();
//		char a = str1.charAt(0);
//		if(a>='a' && a<='z')
//			System.out.println("소문자 입니다");
//		else if(a>='A' && a<='Z')
//			System.out.println("대문자 입니다");
//		else if(a<='9' && a>= '0')
//			System.out.println("숫자입니다");
//		else
//			System.out.println("특수문자 입니다");
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		System.out.println("201810754 조윤직");
////		int num1 =32;
////		System.out.println(num1+"=" + Integer.toBinaryString(num1) );
////		
////		System.out.println(num1+"=" + Integer.toBinaryString(num1>>1) );
////		System.out.println(num1+"=" + Integer.toBinaryString(num1<<1) );
//		lab03();
//	}
//
//}
