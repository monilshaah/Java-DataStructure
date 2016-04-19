package designPattern.command;

public class ConcreateReceiver2 implements Receiver {

	@Override
	public void doAction() {
		System.out.println("Receiver slept!");
	}

}