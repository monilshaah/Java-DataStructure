package arrays;

public class AdvanceArrayOperation extends BasicArray {

	public AdvanceArrayOperation(int arraySize) {
		super(arraySize);
	}

	public long medianValue(long[] array, int nElem) {
		int q = nElem/2;
		if (q * 2 == nElem) {
			return (array[q]+array[q+1])/2;
		} else {
			return array[q+1];
		}
	}
	
	public void removeDups() {
		int arrayItem = this.getNumberOfItems();
		int nElem = arrayItem;
		long[] array = this.getLongArray();
		int currentPos = 0;
		for(int index=0; index < nElem;) {
			long currentVal = array[currentPos];
			while(index < nElem && array[index] == currentVal) {
				index++;
				arrayItem--;
			}
			if (index < nElem) {
				currentPos++;
				array[currentPos] = array[index];
				index++;
			}
		}
		this.setLongArray(array);
		this.setNumberOfItems(arrayItem);
	}
}
