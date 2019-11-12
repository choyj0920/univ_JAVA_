package java_1111;

public class MyArray<T> {
	int capacity;
	int count;
	T[] arr;
	public MyArray(int capacity) {
		this.capacity=capacity;
		arr= (T[])new Object[this.capacity];
	}
	public void add(T t) {
		if(this.capacity>count) {
			arr[count++]=t;
		}
	}
	public T getArr(int i) {
		if(i<count)
			return arr[i];
		else
			return null;
	}
	
}
