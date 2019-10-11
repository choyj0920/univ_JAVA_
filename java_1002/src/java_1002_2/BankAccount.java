package java_1002_2;

public class BankAccount {
	private int accountNumber;
	private String customerName;
	private double accountBalance;
	
	public BankAccount() {
		this(0,"noname",0);
	}
	public BankAccount(String customerName) {
		this(0,customerName,0);
	}
	
	public BankAccount(int accountNumber, String customerName) {
		this(accountNumber,customerName,0);
	}
	public BankAccount(int accountNumber, String customerName,double accountBalance) {
		this.accountBalance =accountBalance;
		this.customerName = customerName;
		this.accountNumber =accountNumber;
	
}
	public double getBalance() {
		
		return accountBalance;
	}
	public void deposit(double Amount) {
		this.accountBalance +=Amount;
	}
	public void withdraw(double Amount) {
		if(this.accountBalance >= Amount) {
			this.accountBalance -=Amount;
		}
		else
			System.out.println("ÀÜ¾× ºÎÁ·");
	}
	public void transfer(BankAccount acct, double Amount) {
		if(this.accountBalance >= Amount) {
			this.withdraw(Amount);
			acct.deposit(Amount);
			System.out.println("ÀÌÃ¼ ¿Ï·á");
		}
		else
			System.out.println("ÀÜ¾× ºÎÁ·");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String info = "°èÁÂ ¹øÈ£ : " + this.accountNumber;
		info = info +"\n°í°´ ÀÌ¸§: "+this.customerName;
		info =info +"\n°èÁÂ ÀÜ¾× : "+this.accountBalance;
		return info;
	}
	
}
