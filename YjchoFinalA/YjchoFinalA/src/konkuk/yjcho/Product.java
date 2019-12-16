package konkuk.yjcho;

import java.util.ArrayList;
import java.util.Vector;

public abstract class  Product implements Comparable<Product>{
	String pNum,pName;
	int maxcell,minprice,appli_count;
	Vector<Applicants> sinchung=new Vector<Applicants>();
	public Product(String pNum,int maxcell,int minprice,String pName) {
		// TODO Auto-generated constructor stub
		this.pNum=pNum; this.maxcell=maxcell; this.minprice=minprice; this.pName=pName;
		appli_count=0;
	}
	public abstract void aa();
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "등록번호 : "+pNum+"\n제품 수량 : "+maxcell+"\n최소가격 : "+minprice+"\n";
	}
	String infoa() {
		String ss="\n신청자수 : "+sinchung.size()+"명\n";
		ss+="----신청자 -----\n";
		if(sinchung.size()==0) {
			ss+="신청자 없음 \n\n";
			return ss;
		}
		ArrayList<Applicants> apps=new ArrayList<Applicants>();
		apps.addAll(sinchung);
		apps.sort(null);
		int i=0;
		for(Applicants a:apps) {
			ss+=a+"\n";
			i++;
			if(i>=maxcell)
				break;
		}
		return ss;
	}
	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return pNum.compareTo(o.pNum);
	}
}
