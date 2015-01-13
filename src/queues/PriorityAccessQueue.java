package queues;

public class PriorityAccessQueue {
	private int qSize;
	private int[] queueArray;
	private int rear;

	public PriorityAccessQueue(int qSize) {
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
			int index;
			for (index=rear; index >= 0; index--) {
				if (queueArray[index] < elem) {						//lower key, high priority
					queueArray[index+1] = queueArray[index];
				} else
					break;
			}
			queueArray[++index] = elem;
			rear++;
		} else
			System.out.println("PriorityQ is full!!!");
	}
	
	public int remove() {
		if (!isEmpty()) {
			return queueArray[rear--];
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
		} else {
			System.out.println("PriorityQ is empty!!!");
		}
	}
}

