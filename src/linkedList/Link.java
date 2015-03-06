package linkedList;

public class Link {
	private int linkData;
	private Link next;
	
	public Link(int linkData) {
		this.linkData = linkData;
//		next = null;					// this is by default.
	}
	
	public void setNext(Link next) {
		this.next = next;
	}
	
	public Link getNext() {
		return next;
	}
	
	public int getLinkData() {
		return linkData;
	}
	
	public void setLinkData(int linkData) {
		this.linkData = linkData;
	}

	public void displayLink() {
		System.out.println("linkData:: "+linkData);
	}
}
