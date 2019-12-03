package �������_teampj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class searchGr {
	static ArrayList<int[][]> maps=new ArrayList<>();
	static ArrayList<Integer> way;
	
	//���� �о���� �Լ�
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
			System.out.println("������ ã�� ���߽��ϴ�.");
			e.printStackTrace();
		}
		
	}
	// ���� �켱 Ž�� ��� ����
	public static void Dfs(int[][] map, int v) {
        
        way.add(v);        
        for(int i=1; i<map.length; i++) {
            if(map[v][i] == 1 && !way.contains(i)) {
                Dfs(map, i);
            }
        }
        
    }
	// �ʺ� �켱Ž�� ��� ����
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
	// ��� ����Լ�
	public static void printWay() {
		System.out.print(way.get(0));
		for(int i=1;i<way.size();i++) {
			System.out.print(" - "+way.get(i));
		}
	}
	//��� �Լ�
	public static void print1() {
		for(int i=0;i<maps.size();i++) {
			System.out.println("�׷��� ["+(i+1)+"]");
			System.out.println("-------------------");
			System.out.println("���� �켱 Ž��");		
			way=new ArrayList<>();
			Dfs(maps.get(i),1);
			printWay(); //��� ���
			System.out.println();
			System.out.println("�ʺ� �켱 Ž��");	
			way.clear();
			Bfs(maps.get(i), 1);
			printWay();
			System.out.println("\n-------------------");
		}
	}
	
	

}
