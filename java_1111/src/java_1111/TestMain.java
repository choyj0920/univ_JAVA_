package java_1111;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestMain {
	public static void lab00() {
		MyArray<String> arr1= new MyArray<>(10);
		arr1.add("greenjoa1");
		arr1.add("greenjoa2");
		arr1.add("greenjoa3");
		arr1.add("greenjoa4");
		System.out.println(arr1.getArr(1));
		System.out.println(arr1.getArr(3));
		
		MyArray<Integer> arr2= new MyArray<Integer>(5);
		arr2.add(10);
		arr2.add(20);
		arr2.add(30);
		arr2.add(40);
		System.out.println(arr2.getArr(3));
		System.out.println(arr2.getArr(2));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arraylist=new ArrayList<String>(); 
		List<String> linkedlist=new LinkedList<String>(); 
		
		long starttime;
		long endtime;
		starttime=System.nanoTime();
		for(int i=0; i<10000;i++) {
			arraylist.add(0,String.valueOf(i));
		}
		endtime=System.nanoTime();
		System.out.println("Arraylist : "+ (endtime-starttime)+"ns");
		
		
		starttime=System.nanoTime();
		for(int i=0; i<10000;i++) {
			linkedlist.add(0,String.valueOf(i));
		}
		endtime=System.nanoTime();
		System.out.println("Linkedlist : "+ (endtime-starttime)+"ns");
	}

}
