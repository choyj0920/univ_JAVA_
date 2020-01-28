package konkuk.yjcho;

public class Manager {
	private String Mname;
	static final int maxcount=10;//�ִ� ġ
	private int count;
	private Item[] Ilist;
	private int total;
	public Manager(String mname) {//String �ϳ��� �޾� ��ü ����
		super();
		total=0; //�� ���� 0;
		Mname = mname;
		Ilist=new Item[maxcount]; //�ִ�� �ȼ� �ִ� ��ǰ ��ŭ üũ
		this.count=0; //�Ȱ��ִ� ���� 0��
	}
	
	public void register(Item item) {
		if(count>=maxcount) {//Ȥ�� ��p�� ������ �ִ� �����̻��̶��
			System.out.println("�� �̻� ��� �Ҽ� ����..");
			return;
		}
		if(item instanceof Coffee) { //�������� Ŀ���̸�, Ŀ���̸� �ߺ� �ƴϸ� ���
			for(int i=0;i<count;i++) {
				if(Ilist[i] instanceof Coffee) {
					if(Ilist[i].getIname().equals(item.getIname())) {
						System.out.println("���� �޴��� �ߺ� ��ϵ� �� ����");
						return;
					}
				}
			}
			Ilist[count++]=item;//������ ���
			System.out.println(item.getIname()+" �޴���� �Ϸ�");
		}
		else if(item instanceof Beer) {//���࿡ ���ֶ��
			for(int i=0;i<count;i++) {
				if(Ilist[i] instanceof Beer) {
					if(Ilist[i].getIname().equals(item.getIname())) {//�̸��� ���ٸ�
						Beer b1 =(Beer)Ilist[i];
						Beer b2 =(Beer)item;
						if(b1.isFresh()==b2.isFresh()) {//������ ���ΰ� ���ٸ� ��� x
							System.out.println("���� �޴��� ��ϵɼ� ����");
							return;
						}
					}
				}
			}
			Ilist[count++]=item;
			System.out.println(item.getIname()+" �޴���� �Ϸ�");
		}

	}
	public void order(Client c,Item[] item) {
		for(int i=0;i<item.length;i++) { //������ �ϴϾ� for�� ����
			if(item[i] instanceof Coffee) { //Ŀ�Ƕ�� 
				for(int j=0;j<count;j++) {//�޴��� ��ġ�ϴ� �޴� ã��
					if(Ilist[j] instanceof Coffee) {//�޴��� Ŀ�ǿ�����
						if(item[i].getIname().equals(Ilist[j].getIname())) {
							//Ŀ�Ǵϱ� �̸��� ���ٸ�
							Ilist[j].sellcountup();
							c.setTotal(c.getTotal()+Ilist[j].getPrice()); 
							//�� ������ �ѱ��� �ݾ� ������Ʈ
							total+=Ilist[j].getPrice();
							// total �� �������� ���� �߰�
							System.out.println(item[i].getIname()+ " ���ſϷ�");
							continue;
						}
					}
				}
			}
			else if(item[i] instanceof Beer) {
				if(c.getAge()<19) {//19�� �̸� ���� ���źҰ�
					System.out.println(item[i].getIname()+"��  19�� �̻� ������ �� ����");
					continue;//���� ������(�ݺ�)���� 
				}
				for(int j=0;j<count;j++) {
					if(Ilist[j] instanceof Beer) {
						if(item[i].getIname().equals(Ilist[j].getIname())) {
							//�̸��� ���� �ÿ���
							Beer b1=(Beer)item[i];
							Beer b2=(Beer)Ilist[j];
							if(b1.isFresh() != b2.isFresh())
								continue;//���ƿ��ΰ� �ٸ��� �ٸ��޴�
							
							Ilist[j].sellcountup();
							c.setTotal(c.getTotal()+Ilist[j].getPrice());
							total+=Ilist[j].getPrice();
							System.out.println(item[i].getIname()+ " ���ſϷ�");
							
						}
					}
				}
			}
		}
	}
	public void show() {
		System.out.println(Mname+"�� �Ǹ���Ȳ"); //��º�
		System.out.println("ǰ��\t�ǸŰ���\t���ǸŰ���\t���Ǹűݾ�");
		for(int i=0;i<count;i++) {
			String ss="";
			
			ss += Ilist[i].getIname()+"\t"+Ilist[i].getPrice()+"\t"+Ilist[i].getSellcount()+"\t"+(Ilist[i].getSellcount()*Ilist[i].getPrice());
			System.out.println(ss);
		}
		System.out.println("�� ����� : "+total);
	}
	
	public void showDescTotal(){
		//�� ���ⷮ�� ���� �� ���� ���� ����
		
		System.out.println(Mname+"�� �Ǹ���Ȳ");
		System.out.println("ǰ��\t�ǸŰ���\t���ǸŰ���\t���Ǹűݾ�");
		int row=0,high=0;
		int aa[]=new int[count];//��ũ ������ ���� �޴� ������ŭ �迭 �Ҵ�
		for(int j=0;j<count;j++) {//j+1�� ���ϱ� 1~count�� ���ϱ�
			high=0;
			for(int i=0;i<count;i++) {
				//������ �������� ���� �͵��� 1�� ã��
				if (aa[i] != 0) continue;
				int top=Ilist[i].getTotalprice();
				//����� �޾ƿ���
				if(high<= top) {//i��° ��ü�� ������̴�ũ��
					row=i; //�ε��� ����
					high=top;//�ִ밪 ����
				}
			}
			aa[row]=j+1;//row�� j+1�� ����
			//total += high;
		}
		
		for(int j=0;j<count;j++) {
			for(int i=0;i<count;i++) {
				if(aa[i]==j+1) {// ��ũ �������� ������� ���
					String ss="";
					ss += Ilist[i].getIname()+"\t"+Ilist[i].getPrice()+"\t"+Ilist[i].getSellcount()+"\t"+Ilist[i].getTotalprice();
					System.out.println(ss);
				}
				
			}
		}
		System.out.println("�� ����� : "+total);
	}
	
	
	
	
	
}
