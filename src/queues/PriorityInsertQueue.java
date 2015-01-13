package queues;

public class PriorityInsertQueue {
	private int qSize;
	private int[] queueArray;
	private int rear;

	public PriorityInsertQueue(int qSize) {
		this.qSize = qSize;
		queueArray = new int[qSize];
		rear = -1;
	}
	
	public boolean isEmpty() {
		return (rear == -1);
	}
	
	public boolean isFull() {
		return (rear == qSize-1);
	}
	
	public void insert(int elem) {
		if (!isFull()) {
			queueArray[++rear] = elem;
		} else {
			System.out.println("PriorityQ is full!!!");
		}
	}
	
	public int remove() {
		if (!isEmpty()) {
			int highPriorityData = queueArray[0];
			int highPriorityPos = 0;
			for (int i=1; i <= rear; i++) {
				if (queueArray[i] < highPriorityData) {					// lower key, high priority
					highPriorityData = queueArray[i];
					highPriorityPos = i;
				}
			}
			for (int i=highPriorityPos; i < rear; i++) {
				queueArray[i] = queueArray[i+1];
			}
			rear--;
			return highPriorityData;
		} else {
			System.out.println("PriorityQ is empty!!!");
			return -1;
		}
	}
	
	public void display() {
		if (!isEmpty()) {
			for (int i=0; i <= rear; i++) 
				System.out.print(queueArray[i]);
			System.out.println();
		}
	}
}
