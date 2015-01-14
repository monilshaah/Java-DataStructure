package linkedList;

public class DoubleEndedLinkedList {
	private Link first, last;
	
	public DoubleEndedLinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(int linkData) {
		Link newLink = new Link(linkData);
		insertFirst(newLink);
	}
	
	public void insertFirst(Link newLink) {
		newLink.setNext(first);
		if (isEmpty())
			last = newLink;
		first = newLink;		
	}
	
	public void insertLast(int linkData) {
		Link newLink = new Link(linkData);
		insertLast(newLink);
	}
	
	public void insertLast(Link newLink) {
		if (isEmpty())
			first = newLink;
		else
			last.setNext(newLink);
		last = newLink;
	}
	
	public Link deleteFirst() {
		Link deletedLink = first;
		if (first.getNext() == null)
			last = null;
		first = first.getNext();
		return deletedLink;
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
