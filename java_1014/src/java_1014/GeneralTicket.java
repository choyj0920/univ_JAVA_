package java_1014;

public class GeneralTicket extends Ticket {
	boolean payBycredit;


	public GeneralTicket(int number, double price, boolean payBycredit) {
		super(number, price);
		this.payBycredit = payBycredit;
	}

	public GeneralTicket(int number, double price) {
		super(number, price);
	}

	public boolean isPayBycredit() {
		return payBycredit;
	}

	public void setPayBycredit(boolean payBycredit) {
		this.payBycredit = payBycredit;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		if(this.isPayBycredit()) {
			return (super.getPrice() *1.1) ;
			
		}
		else {
			return super.getPrice();
		}
		
	}

	public GeneralTicket() {
		super();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" / 카드 결제";
	}
	
}
