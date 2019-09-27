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
		System.out.println("게임 시작 ");
		match_count=0;
		mixcard();
		printcard();
		System.out.println("카드는 3초간만 보여집니다");
		Thread.sleep(3000);
		hide_card(true);
		while(true) {
			cmd_cls();
			printcard();
			int x1,x2,y1,y2;
			while(true) {
				try {
					System.out.print("첫 번 째 카드를 선택 하세요(ex.2 3) :");
					x1= scan.nextInt()-1;
					y1= scan.nextInt()-1;
					break;
				} catch (InputMismatchException e) {
					System.out.println("에러 ! 에러 !");
					System.out.println("정수 두 개를 띄어서 제대로 입력해 주세요.");
				}
			}
			while(true) {
				try {
					System.out.print("두 번 째 카드를 선택 하세요(ex.2 3) :");
					x2= scan.nextInt()-1;
					y2= scan.nextInt()-1;
					break;
				} catch (InputMismatchException e) {
					System.out.println("에러 ! 에러 !");
					System.out.println("정수 두 개를 띄어서 제대로 입력해 주세요.");
				}
			}
			boolean match= checkcard(x1,y1,x2,y2);
			if(match) {
				if(match_count==16) {
					
					cmd_cls();
					printcard();
					System.out.println("게임 성공 ");
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
		System.out.println("카드 섞기 완료");
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
				System.out.println("카드를 두개 선택해 주십시요");
				return false;
			}
			if(card_hide[x1][y1]) 
				if(card[x1][y1]==card[x2][y2]) {
					card_hide[x1][y1] =card_hide[x2][y2]= false;
					match_count +=2;
					System.out.println("성공! 두카드는 일치 합니다.");
					return true;
					
				}
				else{
					System.out.println("두 카드는 일치 하지 않습니다");
					System.out.println("힌트 : 고르신 첫번 째 카드는 "+card[x1][y1]+" 입니다");
				}
			else {
				System.out.println("이미 뒤집힌 카드 입니다.");
			}
			return false;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("인덱스 에러 입니다. 정수 4개 모두 1~4의 수를 입력 해주세요 ");
		}
		return false;
	}
}
