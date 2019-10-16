package java_1016;

public class Ticket {
	protected int number;
	protected double price;
	public Ticket() {
		
	}
	public Ticket(int number, double price) {
		super();
		this.number =number;
		this.price =price;
	}
	public int getNumber() {
		return this.number;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return super.toString()+(" / 티켓 번호 :"+this.getNumber()+" / 가격 : "+this.getPrice());
	}
	
	
}
