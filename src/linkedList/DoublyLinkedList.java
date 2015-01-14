package linkedList;

public class DoublyLinkedList {
	private DoublyLink first;
	private DoublyLink last;
	
	public DoublyLinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(int linkData) {
		DoublyLink newLink = new DoublyLink(linkData);
		insertFirst(newLink);
	}
	
	public void insertFirst(DoublyLink newLink) {		
		if (isEmpty()) 
			last = newLink;
		else
			first.setPrev(newLink);
		newLink.setNext(first);
		first = newLink; 
	}
	
	public void insertLast(int linkData) {
		DoublyLink newLink = new DoublyLink(linkData);
		insertLast(newLink);
	}
	
	public void insertLast(DoublyLink newLink) {
		if (isEmpty()) 
			first = newLink;
		else
			last.setNext(newLink);
		newLink.setPrev(last);
		last = newLink;
	}
	
	public void insertAfter(int key, int linkData) {
		if (!isEmpty()) {
			DoublyLink current = first;
			while(current.getLinkData() != key) {
				current = current.getNext();
				if (current == null)
					break;
			}
			if (current != null) {
				DoublyLink newLink = new DoublyLink(linkData);
				newLink.setPrev(current);
				newLink.setNext(current.getNext());
				if (current.getNext() == null)
					last = newLink;
				else
					current.getNext().setPrev(newLink);
				current.setNext(newLink);
			} else
				System.out.println("Key not found...insertion unsuccessful!!!");
		} else
			System.out.println("No key present in DLL!!!");
	}
	
	public DoublyLink deleteFirst() {
		if (!isEmpty()) {
			DoublyLink deletedLink = first;
			first = first.getNext();
			if (first == null) {
				last = null;
			} else {
				first.setPrev(null);
			}
			return deletedLink;	
		}
		System.out.println("DLL is empty!!!");
		return null;
	}
	
	public DoublyLink deleteLast() {
		if (!isEmpty()) {
			DoublyLink deleteLink = last;
			last = last.getPrev();
			if (last == null)
				first = null;
			else
				last.setNext(null);
			return deleteLink;
		}
		System.out.println("DLL is empty!!!");
		return null;
	}
	
	public DoublyLink deleteKey(int key) {
		if (!isEmpty()) {
			DoublyLink current = first;
			while (current.getLinkData() != key) {
				current = current.getNext();
				if (current == null)
					break;
			}
			if (current != null) {
				if (first == last) {
					first = null;
					last = null;
				} else if (current.getNext() == null) {
					last = current.getPrev();
					last.setNext(null);
				} else if (current.getPrev() == null) {
					first = current.getNext();
					first.setPrev(null);
				} else {
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
				}
			return current;
			} else {
				System.out.println("Key "+key+" not found for deletion!!!");
				return null;
			}
		} else {
			System.out.println("DLL is empty!!!");
			return null;
		}
	}
	
	public void displayList() {
		DoublyLink current = first;
		while (current != null) {
			System.out.print(current.getLinkData()+"-->");
			current = current.getNext();
		}
		System.out.println("null");
	}
}
