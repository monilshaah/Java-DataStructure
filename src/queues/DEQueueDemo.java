package queues;

public class DEQueueDemo {
	public static void main(String[] args) {
		DEQueue dq = new DEQueue(10);
		
		dq.insertRear('1');
		dq.insertRear('2');
		dq.insertRear('3');
		dq.insertRear('4');
		dq.insertRear('5');
		
		System.out.println("DEQ: ");
		dq.display();
		
		dq.removeFront();
		
		System.out.println("DEQ: ");
		dq.display();
		
		dq.insertFront('6');
		
		System.out.println("DEQ: ");
		dq.display();
		
		dq.removeRear();
		
		System.out.println("DEQ: ");
		dq.display();
	}

}
