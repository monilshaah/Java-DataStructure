/**
 * @author Monil
 * Basic array operations (no duplicates)
 */

package arrays;

public class BasicArray {
	private int nElem;
	private long[] longArray;
	
	public BasicArray(int arraySize) {
		this.nElem = 0;
		longArray = new long[arraySize];
	}
	
	public int getNumberOfItems() {
		return this.nElem;
	}
	
	public void setNumberOfItems(int nElem) {
		this.nElem = nElem;
	}

	public void setLongArray(long[] longArray) {
		this.longArray = longArray;
	}

	public long[] getLongArray() {
		return this.longArray;
	}
	
	public void insert(long elem) {
		longArray[nElem] = elem;
		nElem++;
	}
	
	public void display() {
		int i;
		for (i = 0; i < nElem; i++) {
			System.out.print(longArray[i]+", ");
		}
		System.out.println();
	}
	
	public int linearSearch(long elem) {
		int i;
		for (i = 0; i < nElem; i++) {
			if (longArray[i] == elem) 
				break;
		}
		if (i == nElem) 
			return -1;				//elem not found
		else 
			return i;
	}
	
	// Binary search for ordered array
	public int binarySearch(long elem) {
		int lowerBound = 0; 
		int upperBound = nElem -1;
		while (true) {
			int index = (lowerBound + upperBound) / 2;
			if (longArray[index] == elem) 
				return index;
			else if (lowerBound == upperBound)
				return -1;			//elem is not found
			else if (longArray[index] > elem) {
				upperBound = index-1;
			} else if(longArray[index] < elem) {
				lowerBound = index+1;
			}
		}
	}
	
	public boolean delete(long elem){
		return this.delete(elem, false);
	}
	
	public boolean delete(long elem, boolean orderedArray) {
		int i;
		if (orderedArray) {
			i = this.binarySearch(elem);
		} else {
			i = this.linearSearch(elem);
		}
		if (i == -1) {		//elem not found
			return false;		
		} else {
			for (;i < nElem; i++)
				longArray[i] = longArray[i+1];
			nElem--;
			return true;
		}
	}
	
	public static void main(String[] args) {
		BasicArray arrayOps = new BasicArray(15);
		arrayOps.insert(1);
		arrayOps.insert(2);
		arrayOps.insert(3);
		arrayOps.insert(4);
		arrayOps.insert(5);
		arrayOps.insert(6);
		arrayOps.insert(7);
		arrayOps.insert(8);
		arrayOps.insert(9);
		arrayOps.insert(10);
		
		arrayOps.display();
		
		//int pos = arrayOps.linearSearch(10);
		int pos = arrayOps.binarySearch(0);
		if (pos == -1)
			System.out.println("item 0 is not found");
		else 
			System.out.println("item 0 present at position "+(pos+1));
		
		boolean result = arrayOps.delete(10, true);			//true - ordered array; false - unordered array
		if (result)
			System.out.println("item 10 is deleted");
		else 
			System.out.println("item 10 is not found");
		
		arrayOps.display();
		
		
		pos = arrayOps.binarySearch(10);
		if (pos == -1)
			System.out.println("item 10 is not found");
		else 
			System.out.println("item 10 present at position "+(pos+1));
		
		arrayOps.delete(0);
	}
}
