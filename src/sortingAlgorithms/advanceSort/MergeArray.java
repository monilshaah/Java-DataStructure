package sortingAlgorithms.advanceSort;

public class MergeArray {
	private int[] dataArray = {5,3,2,6,7,9,1,0};
	private int nElems = 8;
	
	public MergeArray(int max) {
//		dataArray = new int[max];
//		nElems = 0;
	}
	
	public void insert(int num) {
		if (nElems < dataArray.length) 
			dataArray[nElems++] = num;
	}
	
	public String toString() {
		StringBuilder strArray = new StringBuilder();
		for (int i=0; i < dataArray.length; i++)
			strArray.append(dataArray[i]+",");
		return new String(strArray);
	}
	
	
	public void mergeSort(int[] workspace, int lower, int upper) {
		if (lower == upper) return;
		int mid = (lower + upper)/2;
		mergeSort(workspace, lower, mid);
		mergeSort(workspace, mid+1, upper);
		merge(workspace, lower, mid, upper);
	}
	
	public void merge(int[] workspace, int lower, int mid, int upper) {
		int ptr1 = lower, ptr2 = mid+1, j=0;
		
		while(ptr1 <= mid && ptr2 <= upper) {
			if (dataArray[ptr1] <= dataArray[ptr2]) {
				workspace[j++] = dataArray[ptr1++];
			} else {
				workspace[j++] = dataArray[ptr2++];
			}
		}
		
		while(ptr1 <= mid)
			workspace[j++] = dataArray[ptr1++];
		
		while(ptr2 <= upper)
			workspace[j++] = dataArray[ptr2++];
		
		for (int i=0; i<j; j++)
			dataArray[lower+i] = workspace[i];
		
		//System.out.println(dataArray);
	}
}
