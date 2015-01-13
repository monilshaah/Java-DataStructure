package queues;

public class CircularQueueArray extends QueueArray {

	public CircularQueueArray(int qSize) {
		super(qSize);
	}

	public boolean isFull() {
		return (nElem == qSize);
	}
	
	public void insert(char elem) {
		if (!isFull()) {
			if (rear == qSize-1)
				rear = -1;
			queueArray[++rear] = elem;
			nElem++;
		} else 
			System.out.println("Queue is full!!!");
	}
	
	public char remove() {
		if (!isEmpty()) {
			if (front == qSize-1)
				front = 0;
			nElem--;
			return queueArray[front++];
		} else {
			System.out.println("Circular Q is empty!!!");
			return ' ';
		}
	}
	
	public void display() {
		if (rear >= front) {
			for (int i=front; i <= rear; i++) 
				System.out.print(queueArray[i]+",");
			System.out.println();
		} else {
			for (int i=front; i <= qSize-1; i++)
				System.out.print(queueArray[i]+",");
			for (int i=0; i <= rear; i++)
				System.out.print(queueArray[i]+",");
			System.out.println();
		}
	}
}
