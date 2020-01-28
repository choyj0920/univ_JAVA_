package konkuk.yjcho;

public class Beer extends Item {
	private int dosoo;
	private boolean fresh;

	public Beer(String iname, int price,int dosoo,boolean fresh) {
		super(iname, price);
		this.dosoo=dosoo;
		this.fresh = fresh;
		
	}
	public Beer(String iname, boolean fresh) {
		// TODO Auto-generated constructor stub
		this(iname, 0, 0, fresh);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ss;
		if(fresh)
			ss="»ý¸ÆÁÖ";
		else
			ss="";
		return super.toString()+"\t"+this.dosoo+"\t"+ss;
	}
	public boolean isFresh() {
		return fresh;
	}
	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}
	
}
