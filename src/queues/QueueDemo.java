package queues;

public class QueueDemo {
	
	public static void main(String[] args) {
		QueueArray queue = new QueueArray(5);
		
		queue.insert('1');
		queue.insert('2');
		queue.insert('3');
		queue.insert('4');
		queue.insert('5');
		
		System.out.println("Queue:");
		queue.display();
		
		queue.remove();
		queue.remove();
		queue.insert('6');
		
		System.out.println("Queue:");
		queue.display();
	}

}
