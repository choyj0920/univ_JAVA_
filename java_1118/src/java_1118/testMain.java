package java_1118;

import java.util.*;


public class testMain {
	public static void lab00() {
		System.out.println("조윤직");
		Integer[] arr= {1,2,3,4,5,6,7,8,9};
		
		List<Integer> list=Arrays.asList(arr);
		//Collections.addAll();
		Collections.shuffle(list);
		System.out.println(list);
		
		//뒤집기
		Collections.reverse(list);
		System.out.println(list);
		
		System.out.println("==========================");
		//정렬
		Collections.sort(list);
		System.out.println(list);
		
		//꺼꾸로 정렬
		Collections.sort(list,Collections.reverseOrder());
		System.out.println(list);
		
		//탐색
		Collections.sort(list);//탐색전 정렬
		int index =Collections.binarySearch(list, 5);
		System.out.println(index);
		System.out.println(list.get(index));
	}
	static class Student implements Comparable<Student>{
		String name;
		int score;
		static int flag=0;
		Student(String name, int score){
			this.name=name;
			this.score=score;
		}
		Student(String name){
			this.name=name;
			
		}
		public String toString() {
			return "[이름 :"+name+", 성적 : "+score+"]";
		}
		
		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			switch(flag) {
			case 0:
				return name.compareTo(o.name);
			case 1:
				return score-o.score;
			}
			return name.compareTo(o.name);
		}
	}
	public static void lab01_compare() {
		List<Student> list =new ArrayList<Student>();
		list.add(new Student("홍길동",80));
		list.add(new Student("김길동",90));
		list.add(new Student("성길동",65));
		list.add(new Student("안길동",100));
		list.add(new Student("조길동",40));
		list.add(new Student("황길동",20));
		list.add(new Student("고길동",80));
		
//		System.out.println(list);
//		//정렬
//		Student.flag=0;
//		Collections.sort(list);
//		System.out.println(list);
//		//성적순 정렬
//		Student.flag=1;
//		Collections.sort(list,Collections.reverseOrder());
//		System.out.println(list);
		Collections.sort(list);
		
		int index=Collections.binarySearch(list, new Student("고길동"));
		System.out.println(list.get(index));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lab01_compare();
		
	}

}
