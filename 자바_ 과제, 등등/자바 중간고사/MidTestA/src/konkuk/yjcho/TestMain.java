package konkuk.yjcho;

public class TestMain {

	public static void main(String[] args) {
		System.out.println("201810754 ������");
		// TODO Auto-generated method stub
		Item item=new Item("�Ƹ޸�ī��",200);
		System.out.println(item);
		Coffee coffee1=new Coffee("�Ƹ޸�ī��");
		System.out.println(coffee1);
		Coffee coffee2=new Coffee("�Ƹ޸�ī��",200);
		System.out.println(coffee2);
		Coffee coffee3=new Coffee("�Ƹ޸�ī��",200,true);
		System.out.println(coffee3);
		
		Beer beer1 =new Beer("���",400,13,true);
		System.out.println(beer1);
		Beer beer2 =new Beer("���",400,15,false);
		System.out.println(beer2);
		Beer beer3 =new Beer("���",true);
		System.out.println(beer3);
		
		Manager manager=new Manager("�Ǵ�");
		manager.register(new Coffee("�Ƹ޸�ī��",200));
		manager.register(new Coffee("�Ƹ޸�ī��",200));
		manager.register(new Beer("���",500,13,true));
		manager.register(new Beer("���",300,15,false));
		
		Client client1=new Client("ȫ�浿", 18);
		Client client2=new Client("��浿", 20);
		
		manager.order(client1, new Item[] {new Coffee("�Ƹ޸�ī��",true),new Beer("���", false)});
		manager.order(client2, new Item[] {new Coffee("�Ƹ޸�ī��",true),new Beer("���", false),new Beer("���", true)});
	
	
		System.out.println(client1);
		System.out.println(client2);
		
		manager.show();
		manager.showDescTotal();
	}

}
