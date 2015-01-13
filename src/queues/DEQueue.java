package queues;

public class DEQueue {
	private int qSize;
	private char[] queueArray;
	private int nElem;
	private int front;
	private int rear;
	
	public DEQueue(int qSize) {
		this.qSize = qSize;
		queueArray = new char[qSize];
		nElem = 0;
		front = -1;
		rear = -1;
	}
	
	public boolean isEmpty() {
		return (nElem == 0);
	}
	
	public boolean isFull() {
		return (nElem == qSize);
	}
	
	public void insertFront(char elem) {
		if (!isFull() && front > 0) {
			queueArray[--front] = elem;
			nElem++;
		} else if(isFull()) {
			System.out.println("DEQ is full!!!");
		} else {
			System.out.println("Can't add at front!!!");
		}
	}
	
	public void insertRear(char elem) {
		if (!isFull()) {
			queueArray[++rear] = elem;
			if (nElem == 0)
				front = 0;
			nElem++;
		} else {
			System.out.println("DEQ is full!!!");
		}
	}
	
	public char removeFront() {
		if (!isEmpty() && front < qSize-1) {
			nElem--;
			return queueArray[front++];
		} else if (front == qSize-1) {
			char ch = queueArray[front];
			front = -1;
			rear = -1;
			nElem--;
			return ch;
		} else {
			System.out.println("DEQ is empty!!!");
			return ' ';
		}
	}
	
	public char removeRear() {
		if (!isEmpty()) {
			nElem--;
			if (rear == 0)
				front = -1;
			return queueArray[rear--];
		} else {
			System.out.println("DEQ is empty!!!");
			return ' ';
		}
	}
	
	public void display() {
		if (front != -1 || rear != -1) {
			for (int i=front; i <= rear; i++)
				System.out.print(queueArray[i]);
			System.out.println();
		}
	}
}
