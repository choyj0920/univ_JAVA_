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
			System.out.println(account_count+"�� ���� ����.");
			System.out.println("���� ��ȣ �Է� : ");
			account_num =scan.nextInt();
			scan.nextLine();
			System.out.println("���¼����ڸ� �Է� : ");
			name = scan.nextLine();
			System.out.println("ó�� ���� �ݾ� �Է� : ");
			money =scan.nextInt();
			scan.nextLine();
			accounts[account_count] =new BankAccount(account_num,name,money);
			account_count++;
		}
	}
	
	public void deposit() {
		System.out.print("� ���¿��� �󸶸� �Ա��ϽÁٽ��ϱ�? (num money) : ");
		int num;
		double money;
		num =scan.nextInt();
		money =scan.nextDouble();
		num =findAccount(num);
		if(num ==100) {
			System.out.println("���¹�ȣ �Է� ���� ..");
			return;
		}
		accounts[num].deposit(money);
		
	}
	public void withdraw() {
		System.out.print("� ���¿��� �󸶸� ����ϽÁٽ��ϱ�? (num money) : ");
		int num;
		double money;
		num =scan.nextInt();
		money =scan.nextDouble();
		num =findAccount(num);
		if(num ==100) {
			System.out.println("���¹�ȣ �Է� ���� ..");
			return;
		}
		accounts[num].withdraw(money);
	}
	public void transfer() {
		System.out.print("� ���¿��� �󸶸� ����·� ��ü �ұ��? (num1 money num2) : ");
		int num1,num2;
		double money;
		num1 =scan.nextInt();
		money =scan.nextDouble();
		num2 =scan.nextInt();
		num1 =findAccount(num1);
		num2 =findAccount(num2);
		if(num1 ==100| num2==100) {
			System.out.println("���¹�ȣ �Է� ���� ..");
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
				info += (a++) +"�� ���� :\n"+ ba.toString() +"\n";
		}
		return info;
	}
}
