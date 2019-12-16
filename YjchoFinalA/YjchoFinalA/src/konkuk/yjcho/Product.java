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
		return "��Ϲ�ȣ : "+pNum+"\n��ǰ ���� : "+maxcell+"\n�ּҰ��� : "+minprice+"\n";
	}
	String infoa() {
		String ss="\n��û�ڼ� : "+sinchung.size()+"��\n";
		ss+="----��û�� -----\n";
		if(sinchung.size()==0) {
			ss+="��û�� ���� \n\n";
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
