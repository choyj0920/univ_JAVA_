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
				if(scan.next().trim().equals("세탁기")) {
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
					return "==>>현재 최저가 : "+p.minprice;
				return "==>>현재 최저가 : "+apps.get(apps.size()-1).price;
			}
		}
		return "코드 확인 요망";
	}
	String showItem(String code) {
		for(Product p: products) {
			if(p.pNum.equals(code)) {
				return p.toString();
			}
		}
		return "없는 코드";			
	}
	void join(String pNum,Applicants app) {
		for(Product p: products) {
			if(p.pNum.equals(pNum)) {
				for(Applicants a: p.sinchung) {
					if(a.aName.equals(app.aName)) {
						if(app.price<p.minprice) {
							System.out.println(p.minprice+" 가격 이하는 경매 신청이 불가 합니다.= 원래 신청가격을 유지합니다.\n");
							return;
						}
						a.price=app.price;
						System.out.println(a.aName+"님의 신청 가격 정보가 수정되었습니다.");
						System.out.println(app.aName+"님의 경매신청이 완료 되었습니다.\n");
						return;
					}
				}
				if(app.price<p.minprice) {
					System.out.println(p.minprice+" 가격 이하는 경매 신청이 불가 합니다.\n");
					return;
				}
				else {
					p.sinchung.add(app);
					System.out.println(app.aName+"님의 경매신청이 완료 되었습니다.\n");
					return;
				}
				
			}
		}
	}

}
