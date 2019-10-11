package java_1008;
import java_1008.BankAccount;
import java.util.Scanner;
public class BankManager {
	public static Scanner scan =new Scanner(System.in);
	BankAccount[] accounts;
	int account_count;
	public BankManager () {
		accounts = new BankAccount[20];
		account_count = 0;
	}
	public void creat() {
		if(account_count<20) {
			int account_num= 0,money;
			String name;
			System.out.println(account_count+"번 계좌 생성.");
			System.out.println("계좌 번호 입력 : ");
			account_num =scan.nextInt();
			scan.nextLine();
			System.out.println("계좌소유자명 입력 : ");
			name = scan.nextLine();
			System.out.println("처음 넣을 금액 입력 : ");
			money =scan.nextInt();
			scan.nextLine();
			accounts[account_count] =new BankAccount(account_num,name,money);
			account_count++;
		}
	}
	
	public void deposit() {
		System.out.print("어떤 계좌에서 얼마를 입금하시곘습니까? (num money) : ");
		int num;
		double money;
		num =scan.nextInt();
		money =scan.nextDouble();
		num =findAccount(num);
		if(num ==100) {
			System.out.println("게좌번호 입력 오류 ..");
			return;
		}
		accounts[num].deposit(money);
		
	}
	public void withdraw() {
		System.out.print("어떤 계좌에서 얼마를 출금하시곘습니까? (num money) : ");
		int num;
		double money;
		num =scan.nextInt();
		money =scan.nextDouble();
		num =findAccount(num);
		if(num ==100) {
			System.out.println("게좌번호 입력 오류 ..");
			return;
		}
		accounts[num].withdraw(money);
	}
	public void transfer() {
		System.out.print("어떤 계좌에서 얼마를 어떤계좌로 이체 할까요? (num1 money num2) : ");
		int num1,num2;
		double money;
		num1 =scan.nextInt();
		money =scan.nextDouble();
		num2 =scan.nextInt();
		num1 =findAccount(num1);
		num2 =findAccount(num2);
		if(num1 ==100| num2==100) {
			System.out.println("게좌번호 입력 오류 ..");
			return;
		}
		accounts[num1].transfer(accounts[num2], money);
	}
	
	public int findAccount(int target) {
		int targ = 100;
		for(int i=0; i < account_count;i++) {
			if(target == accounts[i].getAccountNumber()) {
				targ =i;
				break;
			}
		}
		
		return targ;
	}
	
	public String toString() {
		String info = "";
		int a=0;
		for(BankAccount ba: accounts){
			if(ba != null)
				info += (a++) +"번 계좌 :\n"+ ba.toString() +"\n";
		}
		return info;
	}
}
