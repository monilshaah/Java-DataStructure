package designPattern.adapter;

public class GreetingsAdapter extends Greetings{
	
	SpecialGreet sg;
	public GreetingsAdapter(SpecialGreet s) {
		sg = s;
	}

	public void greet() {
		sg.welcome();
	}

	public void farewell() {
		sg.sayonara();
	}
}
