package practice.decorator;

public class MyConcreteComponent implements MyComponent{
	String msg;
	
	public MyConcreteComponent(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String greet() {
		return msg;
	}
	
}
