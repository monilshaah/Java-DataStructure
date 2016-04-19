package designPattern.command;

public interface Command {
	public void setReceiver(Receiver r);
	public void execute();
}
