package practice.decorator;

public class ConcreteDecorator2 extends BaseDecorator{
	String addedState;
	
	public ConcreteDecorator2(MyComponent comp, String addedState) {
		super(comp);
		this.addedState = addedState;
	}
	
	public String greet() {
		String str = super.greet();
		return addedBehavior(str);
	}
	
	public String addedBehavior(String str) {
		return str + addedState;
	}
}
