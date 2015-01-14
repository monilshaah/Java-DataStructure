package linkedList;

public class DoubleEndedLLDemo {
	public static void main(String[] args) {
		DoubleEndedLinkedList dell = new DoubleEndedLinkedList();
		
		dell.insertFirst(1);
		dell.insertFirst(2);
		
		System.out.println("Double-ended linkedlist:");
		dell.displayList();
		
		dell.insertLast(3);
		
		System.out.println("Double-ended linkedlist:");
		dell.displayList();
		
		dell.deleteFirst();
		
		System.out.println("Double-ended linkedlist:");
		dell.displayList();
	}
}
