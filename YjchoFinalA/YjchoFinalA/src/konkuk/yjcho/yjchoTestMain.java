package konkuk.yjcho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;



public class yjchoTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 ������");
		
		System.out.println("<=====2��=====>");
		Product p1=new TV("T001", 2, 2000, "�Ǳ� TV", "62��ġ");
		Product p2=new Washer("W001", 2, 500, "�Ǳ���Ź��", "�巳��",true);
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("<====3��-====>");
		AuctionManager manager=new AuctionManager("yjchodatasetA.txt");
		
		System.out.println("<====4��-====>");
		Applicants app=new Applicants("ȫ�浿",1000);
		System.out.println(app);
		
		System.out.println("<====5��-====>");
		manager.join("W001", new Applicants("�ֱ浿",400));
		manager.join("W001", new Applicants("�ֱ浿",700));
		
		
		manager.join("T001", new Applicants("ȫ�浿",2000));
		manager.join("T001", new Applicants("��浿",3200));
		manager.join("T001", new Applicants("�̱浿",3500));
		manager.join("T001", new Applicants("ȫ�浿",4000));
		
		
		
		System.out.println("<====6��-====>");
		System.out.println(manager.showItem("T001"));
		System.out.println("<====7��-====>");
		//���� ���� ����������� �����Ҽ� �ִ� ? or ��û�ѻ���� ����? �ϴ� ������ ��û�ѻ�� �� ������ �Է�
		System.out.println(manager.showLowestPrice("T001"));
		System.out.println(manager.showLowestPrice("T006"));
		
		System.out.println("<====8��-====>");
		MyFrame frame=new MyFrame("201810754 ������", manager);
		
	}

}


