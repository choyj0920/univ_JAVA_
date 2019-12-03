package 전산수학_teampj;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class the_shortest_distance {	
	static ArrayList<int[][]> maps=new ArrayList<>();
	
	public static void readFile() {
		File file=new File("input2.txt");
		try {
			Scanner Fsc=new Scanner(file);
			while(Fsc.hasNext()) {
				int[][] map;
				int size=Fsc.nextInt();
				Fsc.nextLine();
				map=new int[size+1][size+1];
				for(int i=1;i<=size;i++) {
					String line=Fsc.nextLine().trim();
					String[] vertexs=line.split(" ");
					
					for(int k=1;k<vertexs.length;k++,k++) {//인접점, 가중치 
						map[i][Integer.parseInt(vertexs[k])]=Integer.parseInt(vertexs[k+1]);
						map[Integer.parseInt(vertexs[k])][i]=Integer.parseInt(vertexs[k+1]);
						
					}
				}
				for(int i=1;i<=size;i++) 
					for(int j=1;j<=size;j++) 
						if(map[i][j]==0 && i != j)//경로가 없으면 int 최대 값
							map[i][j]=Integer.MAX_VALUE;
					
				maps.add(map);				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 찾지 못했습니다.");
			e.printStackTrace();
		}		
	}
	public static void find_way(int[][] map,int v) {
		String[] ways=new String[map.length];
		for(int i=0;i<ways.length;i++) {
			ways[i]="";
		}
		String stringway=v+"";
		int[] distance = new int[map.length];
		boolean[] visited=new boolean[map.length];
		visited[v]=true;
		distance[v]=0;		
		distance[map.length-1]=map[v][map.length-1];
		for(int i=1;i<map.length;i++)
			if(!visited[i] /*&& map[v][i] !=0*/) {
				distance[i]=map[v][i];
				ways[i] =v+" - "+i;
				
				}
		System.out.print(v);
		for(int i=1;i<map.length;i++)
			if(distance[i]==Integer.MAX_VALUE)
				System.out.print("\t무한");
			else
				System.out.print("\t"+distance[i]);
		System.out.println();
		
		for(int c=1;c<map.length-1;c++) {
			int min=Integer.MAX_VALUE;//
			int minindex=0;
			//최소 값 찾기
			for(int i=1;i < map.length ;i++) {
				if(!visited[i] && distance[i]!=Integer.MAX_VALUE){
					if(distance[i] <= min) {
						min=distance[i];
						minindex=i;
					}
				}
			}
			
			stringway =ways[minindex];
			visited[minindex]=true;
			for(int i=1;i<map.length;i++){
                //방문하지 않았고, min_index 최소 가중치로 정해진 노드와 연결되어 있는 노드
                if(!visited[i] && map[minindex][i]!=Integer.MAX_VALUE){
                	//if(map[minindex][i] ==) continue;
                    if(distance[i]>distance[minindex]+map[minindex][i]){//현재 합산된 최소가중치 합이 다른 루트를 통해 합산된 가중치보다 크면 최소거리 값 교체
                        distance[i] = distance[minindex]+map[minindex][i];
                        ways[i] =stringway+" - "+i;
                    }
                }
            }
			System.out.print(minindex);
			for(int i=1;i<map.length;i++)
				if(distance[i]==Integer.MAX_VALUE)
					System.out.print("\t무한");
				else
					System.out.print("\t"+distance[i]);
			System.out.println();
			
		}
		System.out.println("시작점: "+ v);
		for(int i=1;i<map.length;i++) {
			if(i==v)
				continue;
			System.out.println("정점 ["+i+"] : "+ways[i]+", 길이 : "+distance[i]);
		}
	}
	public static void print2() {
		for(int i=0;i<maps.size();i++) {
			System.out.println("그래프 ["+(i+1)+"]");
			System.out.println("========================");
			find_way(maps.get(i),1);
			System.out.println("\n========================");
		}
		
	}
	
}