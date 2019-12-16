package konkuk.yjcho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;



public class yjchoTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 조윤직");
		
		System.out.println("<=====2번=====>");
		Product p1=new TV("T001", 2, 2000, "건국 TV", "62인치");
		Product p2=new Washer("W001", 2, 500, "건국세탁기", "드럼형",true);
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("<====3번-====>");
		AuctionManager manager=new AuctionManager("yjchodatasetA.txt");
		
		System.out.println("<====4번-====>");
		Applicants app=new Applicants("홍길동",1000);
		System.out.println(app);
		
		System.out.println("<====5번-====>");
		manager.join("W001", new Applicants("최길동",400));
		manager.join("W001", new Applicants("최길동",700));
		
		
		manager.join("T001", new Applicants("홍길동",2000));
		manager.join("T001", new Applicants("김길동",3200));
		manager.join("T001", new Applicants("이길동",3500));
		manager.join("T001", new Applicants("홍길동",4000));
		
		
		
		System.out.println("<====6번-====>");
		System.out.println(manager.showItem("T001"));
		System.out.println("<====7번-====>");
		//최저 가격 현재기준으로 낙찰할수 있는 ? or 신청한사람중 최저? 일단 결과대로 신청한사람 중 최저로 입력
		System.out.println(manager.showLowestPrice("T001"));
		System.out.println(manager.showLowestPrice("T006"));
		
		System.out.println("<====8번-====>");
		MyFrame frame=new MyFrame("201810754 조윤직", manager);
		
	}

}


