package designPattern.iterator;

import java.util.ArrayList;

public class MyArrayList implements MyList{

	ArrayList<String> arr = new ArrayList<String>();
	
	@Override
	public MyIterator createIterator() {
		return new MyArrayListIterator(this);
	}
	
	@Override
	public void add(String str) {
		arr.add(str);
	}
	
	@Override
	public void get(int num) {
		System.out.println(arr.get(num));
	}
	
	public int size() {
		return arr.size();
	}
}
