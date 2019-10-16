package java_1016;

public class TicketManager {
	private Ticket[] tickets;
	private int number; //
	private int count;
	private int total;
	private String name; //���� ��
	
	public TicketManager() {
		
	}

	public void register(Ticket ticket) {
		if(number > count) {
			tickets[count++] =ticket;
		}
		else {
			System.out.println("����");
		}
	}
	
	public double getTotal() {
		this.total= 0;
		for(Ticket ticket : tickets) {
			if(ticket!=null)
				total += ticket.getPrice();
		}
		return this.total;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public TicketManager(int number, String name) {
		super();
		this.number = number;
		this.name = name;
		this.tickets= new Ticket[this.number];
	}
	void showGeneralTicket(boolean credit) {
		for(Ticket ticket : tickets) {
			if(ticket instanceof GeneralTicket) {
				GeneralTicket tick=(GeneralTicket)ticket;
				if(tick.isPayBycredit()==credit)
					System.out.println(tick.toString());
			}
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str="";
		str +="���� �� : "+this.name+"\n";
		for(Ticket ticket : tickets) {
			if(ticket != null) 
				str += ticket.toString()+"\n";
		}
		str +="�� �ݾ� : ";
		str += this.getTotal();
		return str;
	}
}
