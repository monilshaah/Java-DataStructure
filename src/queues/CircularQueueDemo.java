package queues;

public class CircularQueueDemo {

	public static void main(String[] args) {
		CircularQueueArray circularQ = new CircularQueueArray(5);
		
		circularQ.insert('1');
		circularQ.insert('2');
		circularQ.insert('3');
		circularQ.insert('4');
		circularQ.insert('5');
		
		System.out.println("Circular Q:");
		circularQ.display();
		
		circularQ.insert('6');
		
		circularQ.remove();
		circularQ.remove();
		circularQ.insert('7');
		
		System.out.println("Circular Q:");
		circularQ.display();
	}

}
