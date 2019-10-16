package java_1016;


public class AdvanceTicket extends Ticket {
	int day;

	public AdvanceTicket() {
		this(0,0,0);
	}

	public AdvanceTicket(int number, double price, int day) {
		super(number, price);
		this.day = day;
	}

	public AdvanceTicket(int number, double price) {
		this(number, price,0);
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		if(this.day>30)
			return super.getPrice()*0.6;
		else if (this.day>20)
			return super.getPrice()*0.7;
		else if (this.day>10)
			return super.getPrice()*0.8;
		else if (this.day>5)
			return super.getPrice()*0.9;
		else
			return super.getPrice();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" / 사전 예약 일수 : "+this.getDay();
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public AdvanceTicket(int day) {
		super();
		this.day = day;
	}

}
