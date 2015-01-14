package linkedList;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		
		ll.insertFirst(1);
		ll.insertFirst(2);
		ll.insertFirst(3);
		ll.insertFirst(4);
		ll.insertFirst(5);
		
		System.out.println("LinkedList:");
		ll.displayList();
		
		ll.deleteFirst();
		
		System.out.println("LinkedList:");
		ll.displayList();
		
		Link temp = ll.find(3);
		if (temp != null)
			System.out.println("Found 3!!!");
		else 
			System.out.println("3 not found!!!");
		
		temp = ll.delete(3);
		if (temp != null)
			System.out.println("Deleted 3");
		else 
			System.out.println("3 not found!!!");
		
		ll.displayList();
		
		temp = ll.deleteAt(3);
		if (temp != null)
			System.out.println("Deleted from pos 3");
		else 
			System.out.println("Link is not present at 3!!!");
		
		ll.displayList();

	}
}
