package java_0923;
import java.util.Random;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.lang.String;
import java.util.Scanner;
import java.io.File;

public class Testmain {

	static Scanner scan =new Scanner(System.in);
	//실습1
	public static void lab01() {
		int[][] arr =makeArray2D();
		printarr(arr);
	}
	public static int[][] makeArray2D() {
		Random rand =new Random();
		
		System.out.print("원하는 층의 개수를 입력하세요 :");
		
		int []count= new int[scan.nextInt()];
		int [][] array =new int[count.length][];
		for(int i=0;i<count.length;i++) {
			System.out.print(i+"층의 방의 개수 : ");
			count[i]= scan.nextInt();
			array[i] = new int[count[i]];
		}
		for(int i=0;i<count.length;i++)
			for(int j=0;j<count[i];j++)
				array[i][j] = rand.nextInt(100);
		return array;
	}
	public static void printarr(int[][] arr) {
		for(int i=0;i<arr.length ;i++) {
			System.out.print(i+"층 : ");
			for(int j=0; j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	// 실습 2
	public static void lab02() {		
		int[][] map = readMap();
		showMap(map);
	}
	public static void showMap(int[][] map) {
		// TODO Auto-generated method stub
		String[] map_com = {"□","■","@"};
		for(int [] i :map) {
			for(int j : i) {
				System.out.print(map_com[j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] readMap(){
		int[][] map =null;
		File file = new File("map.txt");
		
		try {
			Scanner scanner = new Scanner(file);
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			map =new int [row][col];
			
			for(int i=0;i< map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					map[i][j] = scanner.nextInt();
				}
			}
			scanner.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("파일 이름과 경로를 확인하세요!!!");
		}
		
		return map;
	}
	public static void lab03() {
		System.out.println("두 수를 입력해 주세요");
	}
	
	public static void main(String[] args) {
		System.out.println("201810754 조윤직");
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 =Integer.parseInt(args[2]);
			Class classes = Class.forName("java.lang.String");
			System.out.println("합 = "+(num1+num2));
		}catch(NumberFormatException e) {
			//e.printStackTrace();
			System.out.println("인수의 타입 체크하세요!!");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열인자 범위 체크");
		}catch(Exception e) {
			System.out.println("예외 처리 요망");
		}
		
		
	}
	
}
