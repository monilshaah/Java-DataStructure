package linkedList;

public class DoublyLinkedListDemo {
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		
		dll.insertLast(1);
		dll.insertLast(2);
		dll.insertFirst(3);
		dll.insertFirst(4);
		dll.insertFirst(5);
		System.out.println("Doubly Linked List:");
		dll.displayList();
		
		dll.deleteFirst();
		System.out.println("Doubly Linked List:");
		dll.displayList();
		
		dll.deleteLast();
		System.out.println("Doubly Linked List:");
		dll.displayList();
		
		dll.insertAfter(1, 2);
		System.out.println("Doubly Linked List:");
		dll.displayList();
		
		dll.deleteKey(1);
		System.out.println("**Doubly Linked List:");
		dll.displayList();
		
		dll.deleteKey(2);
		System.out.println("Doubly Linked List:");
		dll.displayList();
		
		dll.deleteKey(4);
		System.out.println("Doubly Linked List:");
		dll.displayList();
		
		dll.deleteKey(3);
		System.out.println("Doubly Linked List:");
		dll.displayList();
	}
}
