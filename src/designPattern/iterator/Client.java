package designPattern.iterator;

public class Client {
	public static void main(String[] args) {
		MyList list = new MyArrayList();
		
		list.add("one");
		list.add("two");
		list.add("three");
		
		MyIterator iter1 = list.createIterator();
		MyIterator iter2 = list.createIterator();
		
		iter1.currentItem();
		
		iter2.currentItem();
		iter2.hasNext();
		iter2.next();
		
		iter1.currentItem();
		
		iter2.currentItem();
		iter2.hasNext();
		iter2.next();
		
		iter1.currentItem();
		
		iter2.currentItem();
		iter2.hasNext();
		iter2.next();
		
		iter1.currentItem();

		iter2.hasNext();
	}
}
