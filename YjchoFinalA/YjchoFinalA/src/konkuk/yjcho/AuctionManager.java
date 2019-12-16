package konkuk.yjcho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class AuctionManager {
	Vector<Product> products=new Vector<Product>();
	AuctionManager(String filepath){
		File file= new File(filepath);
		Scanner scan;
		try {
			scan = new Scanner(file);
			while(scan.hasNext()) {
				if(scan.next().trim().equals("��Ź��")) {
					products.add(new Washer(scan.next(), scan.nextInt(), scan.nextInt(),
							scan.next(), scan.next(), scan.nextBoolean()));
					scan.nextLine();
				}
				else {
					products.add(new TV(scan.next(), scan.nextInt(), scan.nextInt(),
							scan.next(), scan.next()));
					scan.nextLine();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	String showLowestPrice(String code) {
		for(Product p: products) {
			if(p.pNum.equals(code)) {
				ArrayList<Applicants> apps=new ArrayList<Applicants>();
				apps.addAll(p.sinchung);
				apps.sort(null);
				if(apps.size()==0)
					return "==>>���� ������ : "+p.minprice;
				return "==>>���� ������ : "+apps.get(apps.size()-1).price;
			}
		}
		return "�ڵ� Ȯ�� ���";
	}
	String showItem(String code) {
		for(Product p: products) {
			if(p.pNum.equals(code)) {
				return p.toString();
			}
		}
		return "���� �ڵ�";			
	}
	void join(String pNum,Applicants app) {
		for(Product p: products) {
			if(p.pNum.equals(pNum)) {
				for(Applicants a: p.sinchung) {
					if(a.aName.equals(app.aName)) {
						if(app.price<p.minprice) {
							System.out.println(p.minprice+" ���� ���ϴ� ��� ��û�� �Ұ� �մϴ�.= ���� ��û������ �����մϴ�.\n");
							return;
						}
						a.price=app.price;
						System.out.println(a.aName+"���� ��û ���� ������ �����Ǿ����ϴ�.");
						System.out.println(app.aName+"���� ��Ž�û�� �Ϸ� �Ǿ����ϴ�.\n");
						return;
					}
				}
				if(app.price<p.minprice) {
					System.out.println(p.minprice+" ���� ���ϴ� ��� ��û�� �Ұ� �մϴ�.\n");
					return;
				}
				else {
					p.sinchung.add(app);
					System.out.println(app.aName+"���� ��Ž�û�� �Ϸ� �Ǿ����ϴ�.\n");
					return;
				}
				
			}
		}
	}

}
