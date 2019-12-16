package konkuk.yjcho;

class Washer extends Product{
	String type;
	boolean gunjo;
	public Washer(String pNum,int maxcell,int minprice,String pName,String type,boolean gunjo) {
		// TODO Auto-generated constructor stub
		super(pNum, maxcell, minprice, pName);
		this.gunjo=gunjo;
		this.type=type;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"제품유형 : "+type+"\n건조기능 : "+
				(gunjo?"있음":"없음")+infoa();
	}
	@Override
	public void aa() {
		// TODO Auto-generated method stub
		
	}
}
