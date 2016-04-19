package designPattern.observer;

public class ConcreteObserverHappy implements Observer{
	String objState;
	Subject subject;
	
	public ConcreteObserverHappy(Subject sub) {
		subject = sub;
	}
	
	@Override
	public void update() {
		System.out.println("Obj updated and he is happy!!!");
	}
	
	
}
