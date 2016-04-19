package practice.decorator;

public class Client {
	public static void main(String[] args) {
		MyComponent comp = new ConcreteDecorator2(new ConcreteDecorator(new MyConcreteComponent("Hello there"), "...How are you?"),"...farewell!!!");
		System.out.println(comp.greet());
	}
}
