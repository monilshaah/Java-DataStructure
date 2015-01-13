package queues;

public class PriorityQDemo {
	public static void main(String[] args) {
		PriorityAccessQueue paq = new PriorityAccessQueue(10);
		
		paq.insert(3);
		paq.insert(2);
		paq.insert(4);
		paq.insert(5);
		paq.insert(1);
		
		System.out.println("PriorityQ Access: ");
		paq.display();
		
		System.out.println(paq.remove()+" removed...");
		System.out.println(paq.remove()+" removed...");
		
		System.out.println("PriorityQ Access: ");
		paq.display();
		
		PriorityInsertQueue piq = new PriorityInsertQueue(10);
		
		piq.insert(3);
		piq.insert(2);
		piq.insert(4);
		piq.insert(5);
		piq.insert(1);
		
		System.out.println("PriorityQ Insert: ");
		piq.display();
		
		System.out.println(piq.remove()+" removed...");
		System.out.println(piq.remove()+" removed...");
		
		System.out.println("PriorityQ Insert: ");
		piq.display();

	}
}
