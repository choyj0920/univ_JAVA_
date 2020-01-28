package konkuk.yjcho;

public class Client {
	private String Cname;
	private int age;
	private int total;
	
	public Client(String cname, int age) {
		super();
		this.Cname = cname;
		this.age = age;
		total=0;
	}
	public String getgrade() {
		String ss;
		if(total==0)
			ss="Family";
		else if(total<=1000)
			ss = "Silver";
		else if(total <=2000)
			ss = "Gold";
		else
			ss="VIP";
		return ss;
	}
	@Override
	public String toString() {
		return "이름 : " + Cname + "/ 총 구매금액 : " + total +"/ 등급 : "+ getgrade();
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
}
