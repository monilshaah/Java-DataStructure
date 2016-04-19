package designPattern.cor;

public class ConcreteHandler implements Handler{
	Handler successor = null;

	@Override
	public void handleRequest(String req) {
		if (req.equals("r1")) {
			System.out.println("H1 handled request");
		} else if(successor != null) {
			System.out.println("forwarding request");
			successor.handleRequest(req);
		}
	}

	@Override
	public void setSuccessor(Handler h) {
		successor = h;
	}
	
}
