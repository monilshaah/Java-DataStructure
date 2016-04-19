package designPattern.command;

public class ConcreteReceiver implements Receiver {

	@Override
	public void doAction() {
		System.out.println("Receiver performed action!");
	}

}
