package konkuk.yjcho;

public class TestMain {

	public static void main(String[] args) {
		System.out.println("201810754 조윤직");
		// TODO Auto-generated method stub
		Item item=new Item("아메리카노",200);
		System.out.println(item);
		Coffee coffee1=new Coffee("아메리카노");
		System.out.println(coffee1);
		Coffee coffee2=new Coffee("아메리카노",200);
		System.out.println(coffee2);
		Coffee coffee3=new Coffee("아메리카노",200,true);
		System.out.println(coffee3);
		
		Beer beer1 =new Beer("라거",400,13,true);
		System.out.println(beer1);
		Beer beer2 =new Beer("라거",400,15,false);
		System.out.println(beer2);
		Beer beer3 =new Beer("라거",true);
		System.out.println(beer3);
		
		Manager manager=new Manager("건대");
		manager.register(new Coffee("아메리카노",200));
		manager.register(new Coffee("아메리카노",200));
		manager.register(new Beer("라거",500,13,true));
		manager.register(new Beer("라거",300,15,false));
		
		Client client1=new Client("홍길동", 18);
		Client client2=new Client("김길동", 20);
		
		manager.order(client1, new Item[] {new Coffee("아메리카노",true),new Beer("라거", false)});
		manager.order(client2, new Item[] {new Coffee("아메리카노",true),new Beer("라거", false),new Beer("라거", true)});
	
	
		System.out.println(client1);
		System.out.println(client2);
		
		manager.show();
		manager.showDescTotal();
	}

}
