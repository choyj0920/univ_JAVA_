package java_1211_�⸻���;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1�� 
		System.out.println("201810754 ������");
		//2��
		Customer c1= new Customer("ȫ�浿", "010-1234-1234");
		Customer c2= new FCMember("ȫ�浿", "010-1234-1234","�����","�λ�");
		System.out.println(c1);
		System.out.println(c2);
		//3��
		Concert concert=new Concert("�̽�ȯ", "�̽�ȯ �ܼ�Ʈ", 2000);
		concert.add(new Customer("ȫ�浿", "ȫ�浿 ��ȣ"));
		concert.add(new FCMember("���浿", "���浿 ��ȣ","� ����","�λ�"));
		concert.add(new FCMember("�̱浿", "�̱浿 ��ȣ","�����","����"));
		concert.add(new FCMember("�۱浿", "�۱浿 ��ȣ","�����","����"));
		System.out.println(concert);
		//4��
		System.out.println(concert.findFCArea("����"));
		//5��
		System.out.println("5��======");
		ConcertManager manager =new ConcertManager();
		manager.addConcert(new Concert("�̽�ȯ", "�̽�ȯ �ܼ�Ʈ",2000));
		manager.addConcert(new Concert("����ȯ", "����ȯ �ܼ�Ʈ",1600));
		manager.addConcert(new Concert("������", "������ �ܼ�Ʈ",1700));
		Concert c= manager.concert.get("�̽�ȯ");
		c.add(new Customer("ȫ�浿", "010-1234-1234"));
		c.add(new FCMember("��浿", "010-1235-1234","�����","�λ�"));
		c.add(new FCMember("�̱浿", "010-1236-1234","�����","����"));
		c=manager.concert.get("����ȯ");
		c.add(new Customer("ȫ�浿", "010-1234-1234"));
		c.add(new FCMember("��浿", "010-1235-1234","�����2","����"));
		c.add(new FCMember("�̱浿", "010-1236-1234","�����2","����"));
		c.add(new FCMember("��浿", "010-2237-1234","�����2","����"));
		
		c=manager.concert.get("������");
		c.add(new Customer("���浿", "010-1234-1234"));
		c.add(new FCMember("��浿", "010-1235-1234","������","�λ�"));
		//6��
		System.out.println("6�� ====");
		System.out.println(manager.sort("1"));
		System.out.println(manager.sort("2"));
		
		//7��
		
		MyFrame my=new  MyFrame("201810754 ������",manager);		
	}

}
class Customer{
	String name;
	String pNumber;
	public Customer(String name, String pNumber) {
		this.name=name;
		this.pNumber=pNumber;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "���̸� : "+name+"\n��ȭ��ȣ : "+pNumber+"\n";
	}
}
class FCMember extends Customer implements checkFCMember{
	
	String fcName;
	String area;
	public FCMember(String name, String pNumber,String fcName, String area) {
		super(name, pNumber);
		this.fcName=fcName;
		this.area=area;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"��Ŭ���� : "+fcName+"\n���� : "+area+"\n";
	}
	@Override
	public String getFCLocation() {
		return area;
	}
	
	
}
class Concert implements Comparable<Concert>{
	
	String code,cName;
	int price;
	Vector<Customer> customers=new Vector<Customer>();
	static String flag="2";
	int totalprice=0;
	
	public Concert(String code,String cName,int price) {
		this.code=code; this.cName=cName; this.price=price;
		// TODO Auto-generated constructor stub
	}
	public void add(Customer cus) {
		customers.add(cus);
		totalprice= customers.size()*price;
	}
	@Override
	public int compareTo(Concert o) {
		// TODO Auto-generated method stub
		switch (flag) {
		case "1":
			return o.totalprice- this.totalprice;
		case "2":
			return this.code.compareTo(o.code);
		}
		return 0;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ss="�ܼ�Ʈ �ĺ� ��ȣ : "+code+"\n"+"�ܼ�Ʈ�� : "+cName+"\n";
		ss +="=========================\n";
		ss +="     ���� ��           \n";
		ss +="=========================\n";
		for(Customer c:customers) {
			ss += c+"------------------\n";
		}
		return ss;
	}
	public String findFCArea(String findArea) {
		String ss="�ܼ�Ʈ �ĺ� ��ȣ : "+code+"\n"+"�ܼ�Ʈ�� : "+cName+"\n";
		ss +="=========================\n";
		ss +="     ���� ��           \n";
		ss +="=========================\n";
		for(Customer c:customers) {
			if(c instanceof checkFCMember) {
				checkFCMember temp=(checkFCMember)c;
				if(temp.getFCLocation().equals(findArea)) {
					ss += c+"------------------\n";
				}	
			}			
		}
		return ss;
	}
	
}
interface checkFCMember{
	public String getFCLocation();
}
class ConcertManager{
	HashMap<String, Concert> concert=new HashMap<String, Concert>();
	
	public void addConcert(Concert c) {
		if(concert.containsKey(c.code)) {
			
		}
		else {
			concert.put(c.code, c);
		}
	}
	String sort(String flag) {
		String ss="";
		ArrayList<Concert> list=new ArrayList<Concert>();
		list.addAll(concert.values());
		Concert.flag=flag;
		list.sort(null);
		for(Concert c :list) {
			ss+=c;
		}
		return ss;
	}
	
}
