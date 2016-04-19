package sortingAlgorithms.advanceSort;

public class MergeSort {
	int[] array = {9,3,4,6,2,1,8};
	int nElem = 7;
	
	public void mergeSort() {
		recMergeSort(new int[nElem], 0, nElem-1);
	}
	
	public void recMergeSort(int[] workspace, int lower, int upper) {
		if (lower == upper) return;
		
		int mid = (lower + upper)/2;
		
		recMergeSort(workspace, lower, mid);
		
		recMergeSort(workspace, mid+1, upper);
		
		merge(workspace, lower, mid+1, upper);
	}
	
	public void merge(int[] workspace, int lower, int mid, int upper) {
		int lowerPtr = lower, j = 0, lowerEnd = mid-1;
		while (lowerPtr <= lowerEnd && mid <= upper ) {
			if (array[lowerPtr] <= array[mid])
				workspace[j++] = array[lowerPtr++];
			else
				workspace[j++] = array[mid++];
		}
		
		while(lowerPtr <= lowerEnd) {
			workspace[j++] = array[lowerPtr++];
		}
		
		while(mid <= upper) {
			workspace[j++] = array[mid++];
		}
		
		for(j=0; j <= upper - lower; j++) 
			array[lower+j] = workspace[j];
	}
	
	public static void main(String[] args) {
		MergeSort mg = new MergeSort();
		
		for(int i = 0; i < mg.nElem; i++) 
			System.out.print(mg.array[i]+" ");
		System.out.println();
		
		mg.mergeSort();
		
		for(int i = 0; i < mg.nElem; i++) 
			System.out.print(mg.array[i]+" ");
	}
	
	
}
