package practice.decorator;

public class BaseDecorator implements MyComponent{
	
	MyComponent component;
	
	public BaseDecorator(MyComponent comp) {
		component = comp;
	}
	
	@Override
	public String greet() {
		return component.greet();
	}
	

}
