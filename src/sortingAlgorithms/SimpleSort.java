package sortingAlgorithms;

import arrays.AdvanceArrayOperation;

import java.util.Random;

/**
 * @author Monil
 *	Simple sorting algorithms - Bubble Sort, Selection Sort and Insertion Sort
 */
public class SimpleSort {
	
	public void bubbleSort(long[] array, int nElem) {
		for (int upperBound=nElem-1; upperBound > 0; upperBound--) {
			for (int index=0; index < upperBound; index++) {
				if (array[index] == array[index+1])
					continue;
				else if (array[index] < array[index+1])
					continue;
				else {
					long temp = array[index];
					array[index] = array[index+1];
					array[index+1] = temp;
				}
			}
		}
	}
	
	public void bubbleSortBidirectional(long[] array, int nElem) {
		long temp;
		for (int upperBound=nElem-1, lowerBound=0; upperBound > lowerBound; upperBound--, lowerBound++) {
			for (int index=lowerBound; index < upperBound; index++) {
				if (array[index] == array[index+1])
					continue;
				else if (array[index] < array[index+1])
					continue;
				else {
					temp = array[index];
					array[index] = array[index+1];
					array[index+1] = temp;
				}
			}
			for (int index=upperBound-1; index > lowerBound; index--) {
				if (array[index] == array[index-1])
					continue;
				else if (array[index] > array[index-1]) {
					continue;
				}
				else {
					temp = array[index];
					array[index] = array[index-1];
					array[index-1] = temp;
				}
			}
		}
	}
	
	public void oddEvenSort(long[] array, int nElem) {
		boolean oddSwapped = false, evenSwapped = false;
		while(true) {
			oddSwapped = false;
			for(int oddIndex=1; oddIndex+1 < nElem; oddIndex = oddIndex+2) {
				if (array[oddIndex] > array[oddIndex+1]) {
					oddSwapped = true;
					long temp = array[oddIndex];
					array[oddIndex] = array[oddIndex+1];
					array[oddIndex+1] = temp;
				} 
			}
			
			if (oddSwapped && evenSwapped) {
				break;
			}
			
			evenSwapped = false;
			for(int evenIndex=0; evenIndex+1 < nElem; evenIndex = evenIndex+2) {
				if (array[evenIndex] > array[evenIndex+1]) {
					evenSwapped = true;
					long temp = array[evenIndex];
					array[evenIndex] = array[evenIndex+1];
					array[evenIndex+1] = temp;
				}
			}
			
			if (oddSwapped && evenSwapped) {
				break;
			}
		}
	}
	
	public void selectionSort(long[] array, int nElem) {
		int minPos;
		for (int i=0; i < nElem-1; i++) {
			minPos = i;
			for (int j=i+1; j < nElem; j++) {
				if (array[minPos] > array[j]) {
					minPos = j;
				}
			}
			long temp = array[minPos];
			array[minPos] = array[i];
			array[i] = temp;
		}
	}
	
	public void insertionSort(long[] array, int nElem) {
		for (int lowerBound=1; lowerBound < nElem; lowerBound++) {
			int j;
			long currentVal = array[lowerBound];
			for (j=lowerBound; j > 0; j--) {
				if (currentVal < array[j-1])
					array[j] = array[j-1];
				else 
					break;
			}
			array[j] = currentVal;
		}
	}
	
/*	public void insertionSortNoDuplicates(long[] array, int nElem) {
		for (int lowerBound=1; lowerBound < nElem; lowerBound++) {
			int j;
			long currentVal = array[lowerBound];
			for (j=lowerBound; j > 0; j--) {
				if (array[j-1] > currentVal)
					array[j] = array[j-1];
				else if (array[j-1] == currentVal)
					array[j-1] = -1;
				else 
					break;
			}
			array[j] = currentVal;
		}
	}*/
	
	public static void main(String[] args) {
		// Bubble Sort Demo
		AdvanceArrayOperation array = new AdvanceArrayOperation(50);
		Random randomGen = new Random();
		for (int i=0; i < 30; i++)
			array.insert(randomGen.nextInt(100));
		
		System.out.println("Bubble Sort:");
		array.display();
		SimpleSort simpleSort = new SimpleSort();
		long sTime = System.nanoTime();
		simpleSort.bubbleSort(array.getLongArray(), array.getNumberOfItems());
		long eTime = System.nanoTime();
		array.display();
		long execTime = eTime - sTime;
		System.out.println("Execution time: "+execTime);
		
		//Bubble Sort Bidirectional
		AdvanceArrayOperation arrayBubbleSortBidirectional = new AdvanceArrayOperation(50);
		randomGen = new Random();
		for (int i=0; i < 30; i++)
			arrayBubbleSortBidirectional.insert(randomGen.nextInt(100));
		
		System.out.println("Bubble Sort:");
		arrayBubbleSortBidirectional.display();
		simpleSort = new SimpleSort();
		sTime = System.nanoTime();
		simpleSort.bubbleSort(arrayBubbleSortBidirectional.getLongArray(), arrayBubbleSortBidirectional.getNumberOfItems());
		eTime = System.nanoTime();
		arrayBubbleSortBidirectional.display();
		execTime = eTime - sTime;
		System.out.println("Execution time: "+execTime);
		
		// Selection Sort Demo
		AdvanceArrayOperation array1 = new AdvanceArrayOperation(50);
		randomGen = new Random();
		for (int i=0; i < 30; i++)
			array1.insert(randomGen.nextInt(100));
		
		System.out.println("Selection Sort:");
		array1.display();
		sTime = System.nanoTime();
		simpleSort.selectionSort(array1.getLongArray(), array1.getNumberOfItems());
		eTime = System.nanoTime();
		array1.display();
		execTime = eTime - sTime;
		System.out.println("Execution time: "+execTime);
		
		// Insertion Sort Demo
		AdvanceArrayOperation array2 = new AdvanceArrayOperation(50);
		randomGen = new Random();
		for (int i=0; i < 30; i++)
			array2.insert(randomGen.nextInt(100));
	
		System.out.println("Insertion Sort:");
		array2.display();
		sTime = System.nanoTime();
		simpleSort.selectionSort(array2.getLongArray(), array2.getNumberOfItems());
		eTime = System.nanoTime();
		array2.display();
		execTime = eTime - sTime;
		System.out.println("Execution time: "+execTime);
		System.out.println("Median value: "+array2.medianValue(array2.getLongArray(), array2.getNumberOfItems()));
		
		//Remove dups
		array2.removeDups();
		System.out.println("Removing dups..."+array2.getNumberOfItems());
		array2.display();
		
		// Odd Even Sort
		AdvanceArrayOperation array3 = new AdvanceArrayOperation(50);
		randomGen = new Random();
		for (int i=0; i < 30; i++)
			array3.insert(randomGen.nextInt(100));
		
		System.out.println("OddEven Sort:");
		array3.display();
		sTime = System.nanoTime();
		simpleSort.selectionSort(array3.getLongArray(), array3.getNumberOfItems());
		eTime = System.nanoTime();
		array3.display();
		execTime = eTime - sTime;
		System.out.println("Execution time: "+execTime);
		
		
	}
}
