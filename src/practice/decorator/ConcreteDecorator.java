package practice.decorator;

public class ConcreteDecorator extends BaseDecorator{
	String addedState;

	public ConcreteDecorator(MyComponent comp, String addedState) {
		super(comp);
		this.addedState = addedState;
	}
	
	public String greet() {
		String msg = super.greet();
		return addedBehavior(msg);
	}
	
	public String addedBehavior(String str) {
		return str + addedState;
	}
}
