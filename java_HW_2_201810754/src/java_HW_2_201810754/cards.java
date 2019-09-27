package java_HW_2_201810754;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class cards {
	
	static Random rand =new Random();
	static Scanner scan =new Scanner(System.in);
	private int card[][];
	private Boolean card_hide[][];
	int match_count =0;
	
	public void creatcard() {
		card =new int[4][4];
		card_hide= new Boolean[4][4];
		
		for(int i=0;i<4;i++)
			for(int j = 0; j<4;j++) {
				card_hide[i][j]=false;
				card[i][j] = i*2 + j/2 +1;
			}
	}
	
	public void printcard() {
		System.out.printf("%5s","| ");
		System.out.println("1 2 3 4");
		System.out.println("======================");
		for(int i=0;i<4;i++) {
			System.out.printf("%d%4s",i+1 ,"| ");
			for(int j=0;j<4;j++) {
				if(card_hide[i][j])
					System.out.print("* ");
				else
					System.out.print(card[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void cmd_cls() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void gamestart() throws InterruptedException {
		
		cmd_cls();
		System.out.println("���� ���� ");
		match_count=0;
		mixcard();
		printcard();
		System.out.println("ī��� 3�ʰ��� �������ϴ�");
		Thread.sleep(3000);
		hide_card(true);
		while(true) {
			cmd_cls();
			printcard();
			int x1,x2,y1,y2;
			while(true) {
				try {
					System.out.print("ù �� ° ī�带 ���� �ϼ���(ex.2 3) :");
					x1= scan.nextInt()-1;
					y1= scan.nextInt()-1;
					break;
				} catch (InputMismatchException e) {
					System.out.println("���� ! ���� !");
					System.out.println("���� �� ���� �� ����� �Է��� �ּ���.");
				}
			}
			while(true) {
				try {
					System.out.print("�� �� ° ī�带 ���� �ϼ���(ex.2 3) :");
					x2= scan.nextInt()-1;
					y2= scan.nextInt()-1;
					break;
				} catch (InputMismatchException e) {
					System.out.println("���� ! ���� !");
					System.out.println("���� �� ���� �� ����� �Է��� �ּ���.");
				}
			}
			boolean match= checkcard(x1,y1,x2,y2);
			if(match) {
				if(match_count==16) {
					
					cmd_cls();
					printcard();
					System.out.println("���� ���� ");
					return;
				}
			}
			Thread.sleep(1000);
		}		
	}
	
	public void hide_card(boolean hide) {
		for(int i=0;i<4;i++)
			for(int j = 0; j<4;j++) {
				card_hide[i][j]=hide;
			}
	}
	public void mixcard() {
		System.out.println("ī�� ���� �Ϸ�");
		for(int i=0; i<16;i++) {
			int x1= rand.nextInt(4);
			int x2= rand.nextInt(4);
			int y1= rand.nextInt(4);
			int y2= rand.nextInt(4);
			int temp =card[x1][y1];
			card[x1][y1]=card[x2][y2];
			card[x2][y2] =temp;
		}
		hide_card(false);
		
		
	}
	public boolean checkcard(int x1,int y1,int x2,int y2) {
		try {
			if(x1==x2 &&y1 ==y2) {
				System.out.println("ī�带 �ΰ� ������ �ֽʽÿ�");
				return false;
			}
			if(card_hide[x1][y1]) 
				if(card[x1][y1]==card[x2][y2]) {
					card_hide[x1][y1] =card_hide[x2][y2]= false;
					match_count +=2;
					System.out.println("����! ��ī��� ��ġ �մϴ�.");
					return true;
					
				}
				else{
					System.out.println("�� ī��� ��ġ ���� �ʽ��ϴ�");
					System.out.println("��Ʈ : ���� ù�� ° ī��� "+card[x1][y1]+" �Դϴ�");
				}
			else {
				System.out.println("�̹� ������ ī�� �Դϴ�.");
			}
			return false;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("�ε��� ���� �Դϴ�. ���� 4�� ��� 1~4�� ���� �Է� ���ּ��� ");
		}
		return false;
	}
}
