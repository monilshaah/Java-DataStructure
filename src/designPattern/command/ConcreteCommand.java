package designPattern.command;

public class ConcreteCommand implements Command {

	Receiver r;
	
	@Override
	public void setReceiver(Receiver r) {
		this.r = r;
	}

	@Override
	public void execute() {
		r.doAction();
	}
	
}
