package java_1211_기말대비;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1번 
		System.out.println("201810754 조윤직");
		//2번
		Customer c1= new Customer("홍길동", "010-1234-1234");
		Customer c2= new FCMember("홍길동", "010-1234-1234","어린왕자","부산");
		System.out.println(c1);
		System.out.println(c2);
		//3번
		Concert concert=new Concert("이승환", "이승환 콘서트", 2000);
		concert.add(new Customer("홍길동", "홍길동 번호"));
		concert.add(new FCMember("감길동", "감길동 번호","어린 왕자","부산"));
		concert.add(new FCMember("이길동", "이길동 번호","어린왕자","대전"));
		concert.add(new FCMember("송길동", "송길동 번호","어린왕자","대전"));
		System.out.println(concert);
		//4번
		System.out.println(concert.findFCArea("대전"));
		//5번
		System.out.println("5번======");
		ConcertManager manager =new ConcertManager();
		manager.addConcert(new Concert("이승환", "이승환 콘서트",2000));
		manager.addConcert(new Concert("정승환", "정승환 콘서트",1600));
		manager.addConcert(new Concert("아이유", "아이유 콘서트",1700));
		Concert c= manager.concert.get("이승환");
		c.add(new Customer("홍길동", "010-1234-1234"));
		c.add(new FCMember("김길동", "010-1235-1234","어린왕자","부산"));
		c.add(new FCMember("이길동", "010-1236-1234","어린왕자","대전"));
		c=manager.concert.get("정승환");
		c.add(new Customer("홍길동", "010-1234-1234"));
		c.add(new FCMember("김길동", "010-1235-1234","어린왕자2","서울"));
		c.add(new FCMember("이길동", "010-1236-1234","어린왕자2","광주"));
		c.add(new FCMember("고길동", "010-2237-1234","어린왕자2","광주"));
		
		c=manager.concert.get("아이유");
		c.add(new Customer("차길동", "010-1234-1234"));
		c.add(new FCMember("우길동", "010-1235-1234","아이유","부산"));
		//6번
		System.out.println("6번 ====");
		System.out.println(manager.sort("1"));
		System.out.println(manager.sort("2"));
		
		//7번
		
		MyFrame my=new  MyFrame("201810754 조윤직",manager);		
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
		return "고객이름 : "+name+"\n전화번호 : "+pNumber+"\n";
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
		return super.toString()+"팬클럽명 : "+fcName+"\n지역 : "+area+"\n";
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
		String ss="콘서트 식별 번호 : "+code+"\n"+"콘서트명 : "+cName+"\n";
		ss +="=========================\n";
		ss +="     예약 고객           \n";
		ss +="=========================\n";
		for(Customer c:customers) {
			ss += c+"------------------\n";
		}
		return ss;
	}
	public String findFCArea(String findArea) {
		String ss="콘서트 식별 번호 : "+code+"\n"+"콘서트명 : "+cName+"\n";
		ss +="=========================\n";
		ss +="     예약 고객           \n";
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
