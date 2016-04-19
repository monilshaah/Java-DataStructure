package designPattern.iterator;

public interface MyList {
	public MyIterator createIterator();
	public void get(int num);
	public int size();
	public void add(String str);
}
