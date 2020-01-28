package konkuk.yjcho;

public class Coffee extends Item {
	private boolean sul;
	
	public Coffee(String iname) {
		this(iname,0,false);
	}
	public Coffee(String iname,boolean sul) {
		this(iname,0,false);
		this.sul=sul;
	}
	public Coffee(String iname, int price, boolean sul) {
		super(iname, price);
		this.sul = sul;
	}
	public Coffee(String iname, int price) {
		this(iname,price,false);
	}
	@Override
	public String toString() {
		String ss;
		if(sul)
			ss="�����߰� ��";
		else
			ss="�����߰� ����";
		
		return super.toString()+"\t"+ss;
	}

	public boolean isSul() {
		return sul;
	}

	public void setSul(boolean sul) {
		this.sul = sul;
	}
	
}
