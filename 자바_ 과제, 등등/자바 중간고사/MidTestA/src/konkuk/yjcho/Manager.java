package konkuk.yjcho;

public class Manager {
	private String Mname;
	static final int maxcount=10;//최대 치
	private int count;
	private Item[] Ilist;
	private int total;
	public Manager(String mname) {//String 하나를 받아 객체 생성
		super();
		total=0; //총 매출 0;
		Mname = mname;
		Ilist=new Item[maxcount]; //최대로 팔수 있는 물품 만큼 체크
		this.count=0; //팔고있는 종류 0개
	}
	
	public void register(Item item) {
		if(count>=maxcount) {//혹시 등뢱된 갯수가 최대 갯수이상이라면
			System.out.println("더 이상 등록 할수 없음..");
			return;
		}
		if(item instanceof Coffee) { //아이템이 커피이면, 커피이면 중복 아니면 등록
			for(int i=0;i<count;i++) {
				if(Ilist[i] instanceof Coffee) {
					if(Ilist[i].getIname().equals(item.getIname())) {
						System.out.println("같은 메뉴를 중복 등록될 수 없음");
						return;
					}
				}
			}
			Ilist[count++]=item;//아이템 등록
			System.out.println(item.getIname()+" 메뉴등록 완료");
		}
		else if(item instanceof Beer) {//만약에 맥주라면
			for(int i=0;i<count;i++) {
				if(Ilist[i] instanceof Beer) {
					if(Ilist[i].getIname().equals(item.getIname())) {//이름이 같다면
						Beer b1 =(Beer)Ilist[i];
						Beer b2 =(Beer)item;
						if(b1.isFresh()==b2.isFresh()) {//생맥주 여부가 같다면 등록 x
							System.out.println("같은 메뉴를 등록될수 없음");
							return;
						}
					}
				}
			}
			Ilist[count++]=item;
			System.out.println(item.getIname()+" 메뉴등록 완료");
		}

	}
	public void order(Client c,Item[] item) {
		for(int i=0;i<item.length;i++) { //아이템 하니씩 for문 실행
			if(item[i] instanceof Coffee) { //커피라면 
				for(int j=0;j<count;j++) {//메뉴중 일치하는 메뉴 찾기
					if(Ilist[j] instanceof Coffee) {//메뉴중 커피에대해
						if(item[i].getIname().equals(Ilist[j].getIname())) {
							//커피니까 이름만 같다면
							Ilist[j].sellcountup();
							c.setTotal(c.getTotal()+Ilist[j].getPrice()); 
							//고객 정보의 총구매 금액 업데이트
							total+=Ilist[j].getPrice();
							// total 이 아이템의 가격 추가
							System.out.println(item[i].getIname()+ " 구매완료");
							continue;
						}
					}
				}
			}
			else if(item[i] instanceof Beer) {
				if(c.getAge()<19) {//19살 미만 맥주 구매불가
					System.out.println(item[i].getIname()+"는  19세 이상만 구매할 수 있음");
					continue;//다음 아이템(반복)으로 
				}
				for(int j=0;j<count;j++) {
					if(Ilist[j] instanceof Beer) {
						if(item[i].getIname().equals(Ilist[j].getIname())) {
							//이름이 같을 시에는
							Beer b1=(Beer)item[i];
							Beer b2=(Beer)Ilist[j];
							if(b1.isFresh() != b2.isFresh())
								continue;//생맥여부가 다르면 다른메뉴
							
							Ilist[j].sellcountup();
							c.setTotal(c.getTotal()+Ilist[j].getPrice());
							total+=Ilist[j].getPrice();
							System.out.println(item[i].getIname()+ " 구매완료");
							
						}
					}
				}
			}
		}
	}
	public void show() {
		System.out.println(Mname+"점 판매현황"); //출력부
		System.out.println("품명\t판매가격\t총판매개수\t총판매금액");
		for(int i=0;i<count;i++) {
			String ss="";
			
			ss += Ilist[i].getIname()+"\t"+Ilist[i].getPrice()+"\t"+Ilist[i].getSellcount()+"\t"+(Ilist[i].getSellcount()*Ilist[i].getPrice());
			System.out.println(ss);
		}
		System.out.println("총 매출액 : "+total);
	}
	
	public void showDescTotal(){
		//총 매출량이 같을 때 값을 잡지 못함
		
		System.out.println(Mname+"점 판매현황");
		System.out.println("품명\t판매가격\t총판매개수\t총판매금액");
		int row=0,high=0;
		int aa[]=new int[count];//랭크 지정을 위해 메뉴 갯수만큼 배열 할당
		for(int j=0;j<count;j++) {//j+1등 정하기 1~count등 정하기
			high=0;
			for(int i=0;i<count;i++) {
				//순위가 정해지지 않은 것들중 1등 찾기
				if (aa[i] != 0) continue;
				int top=Ilist[i].getTotalprice();
				//매출액 받아오기
				if(high<= top) {//i번째 객체의 매출액이더크면
					row=i; //인덱스 지정
					high=top;//최대값 설정
				}
			}
			aa[row]=j+1;//row를 j+1등 지정
			//total += high;
		}
		
		for(int j=0;j<count;j++) {
			for(int i=0;i<count;i++) {
				if(aa[i]==j+1) {// 랭크 순위부터 순서대로 출력
					String ss="";
					ss += Ilist[i].getIname()+"\t"+Ilist[i].getPrice()+"\t"+Ilist[i].getSellcount()+"\t"+Ilist[i].getTotalprice();
					System.out.println(ss);
				}
				
			}
		}
		System.out.println("총 매출액 : "+total);
	}
	
	
	
	
	
}
