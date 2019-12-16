package konkuk.yjcho;

class Applicants implements Comparable<Applicants>{
	String aName;
	int price;
	Applicants(){
		
	}
	Applicants(String name,int price){
		this.aName=name; this.price=price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "신청자 이름 : "+aName+"\n신청가격 : "+price+"\n";
	}
	@Override
	public int compareTo(Applicants o) {
		// TODO Auto-generated method stub
		return o.price-this.price;
	}

}
