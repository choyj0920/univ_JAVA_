package java_0918;

public class TestMain {

	public static void lab01() {
		String[] name = {"È«±æµ¿","°í±æµ¿","±è±æµ¿","ÀÌ±æµ¿"};
		int score[][]= new int [][] {
			{10,20,30,0},
			{20,30,40,0},
			{10,25,30,0},
			{30,30,40,0}
			};
		for(int i=0 ;i<score.length;i++) {
			for(int j =0;j <score[i].length-1;j++)
				score[i][3] +=score[i][j];
		}
		for(int i=0;i<score.length;i++) {
			System.out.print(name[i]+ " : ");
			for(int j=0;j<score[i].length;j++) {
				System.out.print(score[i][j]+" ");
			}
			System.out.println();
			}

	}
	public static void lab02() {
		String[] name = {"È«±æµ¿","°í±æµ¿","±è±æµ¿","ÀÌ±æµ¿"};
		int score[][]= new int [][] {
			{10,20,30,0},
			{20,30,40,0},
			{10,25,30,0},
			{30,30,40,0}
			};
		
		for(int i=0 ;i<score.length;i++) {
			for(int j =0;j <score[i].length-1;j++)
				score[i][3] +=score[i][j];
		}
		//·©Å© Á¤·Ä  #1
		int rank[] =new int [] {1,2,3,4};
		for(int i=0; i<score.length-1;i++) {
			for(int j = 0; j< score.length;j++ ) {
				if(rank[i]<rank[j] && score[i][3] < score[j][3]) {
					int temp= rank[i];
					rank[i]=rank[j];
					rank[j]= temp;
				}
			}
		}
		for(int i=0;i<score.length;i++) {
			System.out.print(name[i]+ " : ");
			for(int j=0;j<score[i].length;j++) {
				System.out.print(score[i][j]+" ");
			}
			System.out.println(rank[i]+ " ");
		}
		
		//·©Å© Á¤·Ä #2
		rank =new int [] {1,1,1,1};
		for(int i=0; i<score.length;i++) {
			for(int j = 0; j< score.length;j++ ) {
				if(score[i][3] < score[j][3]) {
					rank[i]++;
				}
			}
		}
		
		for(int i=0;i<score.length;i++) {
			System.out.print(name[i]+ " : ");
			for(int j=0;j<score[i].length;j++) {
				System.out.print(score[i][j]+" ");
			}
			System.out.println(rank[i]+ " ");
		}
	}
	public static boolean arrEquals(int [] arr1, int [] arr2) {
	
		if(arr1.length != arr2.length)
			return false;
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i] != arr2[i])
				return false;
		}
		return true;
	}
	public static void lab03() {
		int arr1[]= {1,2,3,4};
		int arr2[] = {1,2,3,4};
		boolean result =arrEquals(arr1,arr2);
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 Á¶À±Á÷");
		lab02();
		
	}

}
