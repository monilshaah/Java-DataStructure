package sortingAlgorithms.advanceSort;

public class MergeSort {
	public static void main(String[] args) {
		MergeArray ma = new MergeArray(8);
		
		System.out.println(ma);
		int[] workspace = new int[10];
		ma.mergeSort(workspace, 0, 7);
		System.out.println(ma);
	}
}
