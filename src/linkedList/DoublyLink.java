package linkedList;

public class DoublyLink {
	private int linkData;
	private DoublyLink next, prev;
	
	public DoublyLink(int linkData) {
		this.linkData = linkData;
	}
	
	public void setNext(DoublyLink next) {
		this.next = next;
	}
	
	public DoublyLink getNext() {
		return next;
	}
	
	public DoublyLink getPrev() {
		return prev;
	}

	public void setPrev(DoublyLink prev) {
		this.prev = prev;
	}

	public int getLinkData() {
		return linkData;
	}
	
	public void displayLink() {
		System.out.println("linkData:: "+linkData);
	}
}
