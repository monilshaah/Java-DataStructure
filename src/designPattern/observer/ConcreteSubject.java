package designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

	List<Observer> list = new ArrayList<>();
	String state = "test";
			
	@Override
	public void attach(Observer obj) {
		list.add(obj);
	}

	@Override
	public void detach(Observer obj) {
		list.remove(obj);
	}

	@Override
	public void notifyObservers() {
		for(Observer obj: list) {
			obj.update();
		}
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String str) {
		state = str;
		System.out.println("State updated!");
		notifyObservers();
	}

}
