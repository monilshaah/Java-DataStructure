package designPattern.observer;

public class Client {
	public static void main(String[] args) {
		ConcreteSubject sub = new ConcreteSubject();
		
		Observer objH = new ConcreteObserverHappy(sub);
		Observer objS = new ConcreteObserverSad(sub);
		
		sub.attach(objS);
		sub.attach(objH);
		
		sub.setState("prod");
	}
}
