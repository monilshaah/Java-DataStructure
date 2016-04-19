package designPattern.adapter;

public class Client {
	public static void main(String[] args) {
		Greetings g = new GeneralGreet();
		
		g.greet();
		g.farewell();
		
		SpecialGreet sg = new SpecialGreet();
		
		sg.welcome();
		sg.sayonara();
		
		Greetings specialGreet = new GreetingsAdapter(sg);
		
		specialGreet.greet();
		specialGreet.farewell();
	}
}
