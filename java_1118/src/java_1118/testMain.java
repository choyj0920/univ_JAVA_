package java_1118;

import java.util.*;


public class testMain {
	public static void lab00() {
		System.out.println("������");
		Integer[] arr= {1,2,3,4,5,6,7,8,9};
		
		List<Integer> list=Arrays.asList(arr);
		//Collections.addAll();
		Collections.shuffle(list);
		System.out.println(list);
		
		//������
		Collections.reverse(list);
		System.out.println(list);
		
		System.out.println("==========================");
		//����
		Collections.sort(list);
		System.out.println(list);
		
		//���ٷ� ����
		Collections.sort(list,Collections.reverseOrder());
		System.out.println(list);
		
		//Ž��
		Collections.sort(list);//Ž���� ����
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
			return "[�̸� :"+name+", ���� : "+score+"]";
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
		list.add(new Student("ȫ�浿",80));
		list.add(new Student("��浿",90));
		list.add(new Student("���浿",65));
		list.add(new Student("�ȱ浿",100));
		list.add(new Student("���浿",40));
		list.add(new Student("Ȳ�浿",20));
		list.add(new Student("��浿",80));
		
//		System.out.println(list);
//		//����
//		Student.flag=0;
//		Collections.sort(list);
//		System.out.println(list);
//		//������ ����
//		Student.flag=1;
//		Collections.sort(list,Collections.reverseOrder());
//		System.out.println(list);
		Collections.sort(list);
		
		int index=Collections.binarySearch(list, new Student("��浿"));
		System.out.println(list.get(index));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lab01_compare();
		
	}

}
