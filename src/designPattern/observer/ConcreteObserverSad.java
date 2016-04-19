package designPattern.observer;

public class ConcreteObserverSad implements Observer{
	String objState;
	Subject subject;
	
	public ConcreteObserverSad(Subject sub) {
		subject = sub;
	}
	
	@Override
	public void update() {
		System.out.println("Obj updated and he is sad!!!");
	}
	
	
}
