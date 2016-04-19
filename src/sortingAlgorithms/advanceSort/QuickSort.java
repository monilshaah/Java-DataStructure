package sortingAlgorithms.advanceSort;

public class QuickSort {
	int[] array = {8,3,25,6,10,17,1,2,18,5};
	int nElem = 10;
	
	public void quickSort() {
		recQuickSort(0, nElem-1);
	}
	
	public void recQuickSort(int left, int right) {
		if (right <= left) return;
		
		int pivot = array[right];
		
		int partition = partitionIt(left, right, pivot);
		
		recQuickSort(left, partition-1);
		
		recQuickSort(partition+1, right);
	}
	
	public int partitionIt(int left, int right, int pivot) {
		int pivotPtr = right;
		left--; 
		while(true) {
			while(array[++left] < pivot);
			
			while(array[--right] > pivot && right > 0);
			
			if (left >= right)
				break;
			else
				swap(left, right);
		}
		swap(left, pivotPtr);
		return left;
	}
	
	public void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		
		for(int i: qs.array) 
			System.out.print(i+" ");
		System.out.println();
		
		qs.quickSort();
		
		for(int i: qs.array) 
			System.out.print(i+" ");
		System.out.println();
	}
}
