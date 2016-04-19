package designPattern.strategy;

public class Client {
	public static void main(String[] args) {
		Context c = new Context();
		
		c.changeStrategy(new ConcreteStrategy1());
		c.executeStrategy();
		
		c.changeStrategy(new ConcreteStrategy2());
		c.executeStrategy();
	}
}
