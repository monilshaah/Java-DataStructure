package designPattern.command;

public class Client {
	public static void main(String[] args) {
		Invoker performInv = new Invoker();
		Command performRcr = new ConcreteCommand();
		Receiver r = new ConcreteReceiver();
		performRcr.setReceiver(r);
		performInv.setCommand(performRcr);
		
		Invoker sleepInv = new Invoker();
		Command sleepRcr = new ConcreteCommand();
		Receiver r2 = new ConcreateReceiver2();
		sleepRcr.setReceiver(r2);
		sleepInv.setCommand(sleepRcr);
		
		performInv.invoke();
		sleepInv.invoke();
		
	}
}
