package konkuk.yjcho;

public class Item {
	private String Iname;
	private int price;
	private int sellcount;
	private int totalprice=0;
	public int getSellcount() {
		return sellcount;
	}
	public void setSellcount(int sellcount) {
		this.sellcount = sellcount;
		this.totalprice=sellcount*price;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public void sellcountup() {
		this.sellcount++;
		totalprice+=price;
	}
	public Item() {
		
	}
	public String getIname() {
		return Iname;
	}
	public void setIname(String iname) {
		Iname = iname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Item(String iname, int price) {
		super();
		Iname = iname;
		this.price = price;
	}
	@Override
	public String toString() {
		return Iname + "\t" + price;
	}
	
	
}
