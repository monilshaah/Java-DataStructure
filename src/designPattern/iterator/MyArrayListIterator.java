package designPattern.iterator;

public class MyArrayListIterator implements MyIterator {

	int current;
	MyList list;
	
	public MyArrayListIterator(MyList list) {
		this.list = list;
		current = 0;
	}
	@Override
	public void currentItem() {
		System.out.println("Current Item::");
		list.get(current);
	}

	@Override
	public void hasNext() {
		if ((list.size() - current) > 0)
			System.out.println("Has next");
		else
			System.out.println("At end!");
	}

	@Override
	public void next() {
		System.out.println("next");
		current += 1;

	}

}
