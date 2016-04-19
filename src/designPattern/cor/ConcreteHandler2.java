package designPattern.cor;

public class ConcreteHandler2 implements Handler{
	Handler successor = null;

	@Override
	public void handleRequest(String req) {
		if (req.equals("r2")) {
			System.out.println("H2 handled request");
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
