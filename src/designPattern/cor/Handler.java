package designPattern.cor;

public interface Handler {
	public void handleRequest(String req);
	public void setSuccessor(Handler h);
}
