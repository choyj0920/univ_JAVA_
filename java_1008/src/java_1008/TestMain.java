package java_1008;
import java_1008.BankManager;
import java_1008.BankAccount;
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankManager bank = new BankManager();
		for(int i=0; i<3;i++) {
			bank.creat();
		}
		System.out.println(bank.toString());
		bank.deposit();
		System.out.println(bank.toString());
		bank.withdraw();
		bank.transfer();
		System.out.println(bank.toString());
	}

}
