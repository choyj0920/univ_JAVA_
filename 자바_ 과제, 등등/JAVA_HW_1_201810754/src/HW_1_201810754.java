import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
public class HW_1_201810754 {

	public static void _HW01() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("====== 택시 요금 누적 ======");
		System.out.println("운행 시작");
		float day =0;
		final int DAY_PAY = 10000;
		final int PAY_PER_KM = 1000;
		do {
			float distance;
			System.out.print("손님  몇 키로를 이동할까요? :");
			distance = scanner.nextFloat();
			day += distance * PAY_PER_KM;
			System.out.println("택시 요금 누적 : "+ day);
		}while(day < DAY_PAY);
		System.out.println("====== 운행 종료 ======");
		System.out.println("수고하셨습니다.");
	}
	
	public static void _HW02() {
		System.out.println("====== 좌표 맞추기 ======");
		Scanner scanner = new Scanner(System.in);
		int x, y, user_x, user_y;
		double distance;
		
		Random rand = new Random();
		x = rand.nextInt(1000) + 1;
		y = rand.nextInt(1000) + 1;
		
		while(true){
			System.out.print("좌표를 맞추세요! (x y) : ");
			user_x =scanner.nextInt();
			user_y =scanner.nextInt();
			distance = Math.sqrt(Math.pow(x-user_x, 2) + Math.pow(y-user_y, 2));
			if(distance > 10) {
				System.out.printf("틀렸습니다. 정답 좌표와의 거리 : %.2f\n",distance);
				if(x >user_x)
					System.out.print("x 값이 더 크고 ");
				else
					System.out.print("x 값이 더 작거나 같고 ");
				if(y > user_y)
					System.out.println("y 값이 더 큽니다. ");
				else
					System.out.println("y 값이 더 작거나 같습니다. ");
				System.out.println("다시 입력하세요.");
			}
			else {
				System.out.println("정답 입니다. ");
				System.out.println("원 좌표 : ("+x+","+y+ ")");
				break;
			}
				
		}
		
	}
	public static void _HW03() {
		System.out.println("====== 구구단 출력하기 ======");
		int count;
		Scanner scanner = new Scanner(System.in);
		System.out.print("출력 단수 : ");
		count = scanner.nextInt();
		
		for(int i = 2; i <= 9 ; i += count) {
			for(int k= 1;k <= 9;k++) {
				for(int j = i ;j < i+count && j<=9; j++)
					System.out.printf("%d * %d = %2d\t",j,k,j*k);
				System.out.println("");
			}
			System.out.println("");
	
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int menu = 0;
		System.out.println("====== 201810754 조윤직 ========");
		while (menu != 4) {
			menu = 0;
			while (menu > 4 || menu < 1) {
				System.out.println("1) 택시 요금 누적 2) 좌표 맞추기 3) 구구단 출력하기  4) 종료");
				System.out.print("메뉴를 선택하세요 : ");
				menu =scanner.nextInt();
			}

			switch (menu)
			{
			case 1:
				_HW01();
				break;
			case 2:
				_HW02();
				break;
			case 3:
				_HW03();
				break;
			case 4:
				break;

			}
		}
	}

}
