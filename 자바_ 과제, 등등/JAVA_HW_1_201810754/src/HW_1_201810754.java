import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
public class HW_1_201810754 {

	public static void _HW01() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("====== �ý� ��� ���� ======");
		System.out.println("���� ����");
		float day =0;
		final int DAY_PAY = 10000;
		final int PAY_PER_KM = 1000;
		do {
			float distance;
			System.out.print("�մ�  �� Ű�θ� �̵��ұ��? :");
			distance = scanner.nextFloat();
			day += distance * PAY_PER_KM;
			System.out.println("�ý� ��� ���� : "+ day);
		}while(day < DAY_PAY);
		System.out.println("====== ���� ���� ======");
		System.out.println("�����ϼ̽��ϴ�.");
	}
	
	public static void _HW02() {
		System.out.println("====== ��ǥ ���߱� ======");
		Scanner scanner = new Scanner(System.in);
		int x, y, user_x, user_y;
		double distance;
		
		Random rand = new Random();
		x = rand.nextInt(1000) + 1;
		y = rand.nextInt(1000) + 1;
		
		while(true){
			System.out.print("��ǥ�� ���߼���! (x y) : ");
			user_x =scanner.nextInt();
			user_y =scanner.nextInt();
			distance = Math.sqrt(Math.pow(x-user_x, 2) + Math.pow(y-user_y, 2));
			if(distance > 10) {
				System.out.printf("Ʋ�Ƚ��ϴ�. ���� ��ǥ���� �Ÿ� : %.2f\n",distance);
				if(x >user_x)
					System.out.print("x ���� �� ũ�� ");
				else
					System.out.print("x ���� �� �۰ų� ���� ");
				if(y > user_y)
					System.out.println("y ���� �� Ů�ϴ�. ");
				else
					System.out.println("y ���� �� �۰ų� �����ϴ�. ");
				System.out.println("�ٽ� �Է��ϼ���.");
			}
			else {
				System.out.println("���� �Դϴ�. ");
				System.out.println("�� ��ǥ : ("+x+","+y+ ")");
				break;
			}
				
		}
		
	}
	public static void _HW03() {
		System.out.println("====== ������ ����ϱ� ======");
		int count;
		Scanner scanner = new Scanner(System.in);
		System.out.print("��� �ܼ� : ");
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
		System.out.println("====== 201810754 ������ ========");
		while (menu != 4) {
			menu = 0;
			while (menu > 4 || menu < 1) {
				System.out.println("1) �ý� ��� ���� 2) ��ǥ ���߱� 3) ������ ����ϱ�  4) ����");
				System.out.print("�޴��� �����ϼ��� : ");
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
