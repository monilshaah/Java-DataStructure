package designPattern.cor;

public class ConcreteHandler3 implements Handler{
	Handler successor = null;

	@Override
	public void handleRequest(String req) {
		if (req.equals("r3")) {
			System.out.println("H3 handled request");
		} else if(successor != null) {
			System.out.println("forwarding request");
			successor.handleRequest(req);
		} else {
			System.out.println("No one to handle");
		}
	}

	@Override
	public void setSuccessor(Handler h) {
		successor = h;
	}
	
}
