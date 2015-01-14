package linkedList;

/**
 * @author Monil
 * Single LinkedList implementation (insertion, deletion, traversing, searching)
 */
public class LinkedList {
	private Link first;
	
	public LinkedList() {
		first = null;			//By default. Written just for clarification
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFront(int linkData) {
		Link newLink = new Link(linkData);
		insertFirst(newLink);
	}
	
	public void insertFirst(Link newLink) {
		newLink.setNext(first);
		first = newLink;
	}
	
	public Link deleteFirst() {
		Link deletedLink = first;
		first = deletedLink.getNext();
		return deletedLink;
	}
	
	public Link find(int searchData) {
		Link current = first;
		while(current != null) {
			if (current.getLinkData() == searchData)
				break;
			current = current.getNext();
		}
		return current;
	}
	
	public Link delete(int key) {
		Link current = first;
		Link previous = first;
		while (current.getLinkData() != key) {
			if (current.getNext() == null)
				return null;
			else {
				previous = current;
				current = current.getNext();
			}
		}
		if (current == first)
			first = first.getNext();
		else
			previous.setNext(current.getNext());
		return current;
	}
	
	public Link deleteAt(int position) {
		Link current = first;
		Link previous = first;
		int linkPos = 1;
		while(linkPos != position) {
			if (current.getNext() == null)
				return null;
			else {
				previous = current;
				current = current.getNext();
				linkPos++;
			}
		}
		if (current == first)
			first = first.getNext();
		else
			previous.setNext(current.getNext());
		return current;
	}
	
	public void displayList() {
		Link current = first;
		while (current != null) {
			System.out.print(current.getLinkData()+"-->");
			current = current.getNext();
		}
		System.out.println("null");
	}
}
