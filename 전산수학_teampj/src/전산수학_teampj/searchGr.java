package 전산수학_teampj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class searchGr {
	static ArrayList<int[][]> maps=new ArrayList<>();
	static ArrayList<Integer> way;
	
	//파일 읽어오는 함수
	public static void readFile() {
		File file=new File("input.txt");
		try {
			Scanner Fsc=new Scanner(file);
			while(Fsc.hasNext()) {
				int[][] map;
				int size=Fsc.nextInt();
				map=new int[size+1][size+1];
				Fsc.nextLine();
				for(int i=1;i<=size;i++) {
					String line=Fsc.nextLine().trim();
					String[] vertexs=line.split(" ");
					for(String vertex:vertexs) {
						map[i][Integer.parseInt(vertex)]=1;
					}
				}
				maps.add(map);				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 찾지 못했습니다.");
			e.printStackTrace();
		}
		
	}
	// 깊이 우선 탐색 경로 설정
	public static void Dfs(int[][] map, int v) {
        
        way.add(v);        
        for(int i=1; i<map.length; i++) {
            if(map[v][i] == 1 && !way.contains(i)) {
                Dfs(map, i);
            }
        }
        
    }
	// 너비 우선탐색 경로 설정
	public static void Bfs(int[][]map,int v) {		
		Queue<Integer> q=new LinkedList<>();
		q.add(v);
		while(!q.isEmpty()) {
			v=q.poll();
			if(!way.contains(v))
				way.add(v);
			for(int i=1;i<map.length;i++) {
				if(map[v][i]==1&&!way.contains(i)) {
					q.add(i);
					
				}
			}			
		}
				
	}
	// 경로 출력함수
	public static void printWay() {
		System.out.print(way.get(0));
		for(int i=1;i<way.size();i++) {
			System.out.print(" - "+way.get(i));
		}
	}
	//출력 함수
	public static void print1() {
		for(int i=0;i<maps.size();i++) {
			System.out.println("그래프 ["+(i+1)+"]");
			System.out.println("-------------------");
			System.out.println("깊이 우선 탐색");		
			way=new ArrayList<>();
			Dfs(maps.get(i),1);
			printWay(); //경로 출력
			System.out.println();
			System.out.println("너비 우선 탐색");	
			way.clear();
			Bfs(maps.get(i), 1);
			printWay();
			System.out.println("\n-------------------");
		}
	}
	
	

}
