package java_1008;

import java_1008.BankAccount;

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
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
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
			System.out.println("�ܾ� ����");
	}
	public void transfer(BankAccount acct, double Amount) {
		if(this.accountBalance >= Amount) {
			this.withdraw(Amount);
			acct.deposit(Amount);
			System.out.println("��ü �Ϸ�");
		}
		else
			System.out.println("�ܾ� ����");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String info = "���� ��ȣ : " + this.accountNumber;
		info = info +"\n�� �̸�: "+this.customerName;
		info =info +"\n���� �ܾ� : "+this.accountBalance;
		return info;
	}
	
}
