package konkuk.yjcho;

public class TV extends Product{
	String size;
	public TV(String pNum,int maxcell,int minprice,String pName,String size) {
		// TODO Auto-generated constructor stub
		super(pNum, maxcell, minprice, pName);
		this.size=size;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"화면 크기 : "+size+infoa();
	}
	@Override
	public void aa() {
		// TODO Auto-generated method stub
		
	}
}