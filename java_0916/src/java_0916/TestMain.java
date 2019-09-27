//package java_0916;
//import java.util.Scanner;
//import java.util.Random;
//public class TestMain {
//
//	public static void lab01() {
//		//실습 1;
//		Random r =new Random();
//		int num[] =new int [6];
//		for(int i=0;i<num.length;i++) {
//			num[i]= r.nextInt(45)+1;
//			for(int j=0 ; j < i ;j++) {
//				if(num[j]==num[i]) {
//					i--;
//					break;
//				}
//			}
//		}
//		for(int i=0; i<num.length-1;i++) 
//			for(int j=i+1; j<num.length;j++) {
//				if(num[i] >num[j]) {
//					int temp = num[j];
//					num[j]= num[i];
//					num[i]=temp;
//				
//					
//				}
//			}
//		System.out.print("로또 번호 :");
//		for(int i : num)
//			System.out.print(i + " ");
//		
//	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println("201810754 조윤직");
//		lab01();
//	}
//
//}
