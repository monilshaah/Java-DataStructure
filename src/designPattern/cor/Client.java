package designPattern.cor;

public class Client {
	public static void main(String[] args) {
		Handler h3 = new ConcreteHandler3();
		Handler h2 = new ConcreteHandler2();
		Handler h1 = new ConcreteHandler();
		
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);
		
		h1.handleRequest("r1");
		h1.handleRequest("r3");
		h1.handleRequest("rr");
		
		
	}
}
