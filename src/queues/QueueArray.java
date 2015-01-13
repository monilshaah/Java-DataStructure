package queues;

public class QueueArray {
	protected int qSize;
	protected char[] queueArray;
	protected int front;
	protected int rear;
	protected int nElem;
	
	public QueueArray(int qSize) {
		this.qSize = qSize;
		queueArray = new char[qSize];
		rear = -1;
		front = 0;
		nElem = 0;
	}
	
	public boolean isEmpty() {
		return (nElem == 0);
	}
	
	public boolean isFull() {
		return (nElem == qSize || rear == qSize-1);
	}
	
	public void insert(char elem) {
		if (!isFull()) { 
			queueArray[++rear] = elem;
			nElem++;
		}
		else 
			System.out.println("Queue is full!!!");
	}
	
	public char remove() {
		if (!isEmpty()) {
			nElem--;
			return queueArray[front++];
		}
		else
			System.out.println("Queue is empty!!!");
		return ' ';
	}
	
	public void display() {
		for (int i=front; i <= rear; i++) {
			System.out.print(queueArray[i]+",");
		}
		System.out.println();
	}
}
