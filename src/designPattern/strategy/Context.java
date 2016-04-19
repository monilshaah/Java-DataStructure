package designPattern.strategy;

public class Context {
	Strategy st;
	
	public void executeStrategy() {
		st.execute();
	}
	
	public void changeStrategy(Strategy st) {
		System.out.println("Changing strategy");
		this.st = st;
	}
}
