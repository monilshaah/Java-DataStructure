package designPattern.adapter;

public class GeneralGreet extends Greetings{
	public void greet() {
		System.out.println("Hello!");
	}
	
	public void farewell() {
		System.out.println("Goodbye!");
	}
}
