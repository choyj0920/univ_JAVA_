package java_1014;

public class testmain {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 조윤직");
		Ticket[] ticket =new Ticket[3];
		ticket[0]= new Ticket(1,100.0);
		ticket[1]=new GeneralTicket(2,100.0,true);
		ticket[2]=new AdvanceTicket(3,200,51);
		for(Ticket t:ticket) {
			if(t instanceof AdvanceTicket) //특정 타입 인지 식별할때
				System.out.println(t);
		}
		System.out.println(ticket[0]);
		System.out.println(ticket[1]);
		System.out.println(ticket[2]);
	}

}
