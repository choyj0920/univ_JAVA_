package java_1016;


public class Testmain {

	public static void lab01() {
		TicketManager ticket1 =new TicketManager(10,"아이유 콘서트");
		ticket1.register(new Ticket(1,1000));
		ticket1.register(new GeneralTicket(2,1000,true));
		ticket1.register(new GeneralTicket(3,1000,false));
		ticket1.register(new AdvanceTicket(4,1000,40));
		ticket1.register(new AdvanceTicket(5,1000,20));
		ticket1.register(new AdvanceTicket(6,1000,5));
		System.out.println(ticket1);
		ticket1.showGeneralTicket(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 조윤직");
		lab01();
	}

}
