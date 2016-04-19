package designPattern.command;

public class Invoker {
	Command cmd;
	
	public void setCommand(Command cmd) {
		this.cmd = cmd;
	}
	
	public void invoke() {
		cmd.execute();
	}
}
