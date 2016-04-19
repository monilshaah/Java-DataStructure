
public class TestEquals {
	String str;
	
	public TestEquals(String str) {
		super();
		this.str = str;
	}
	
	public static void main(String[] args) {
//		TestEquals te = new TestEquals("monil");
//		TestEquals te1 = new TestEquals("monil1");
//		te.equals(te1);
		
		String str = "A";
//		try {
//			int test = Integer.parseInt(str);
//			System.out.println("int..");
//		} catch(NumberFormatException nfe) {
//			System.out.println("not a int..");
//		}
		String[] test1 = str.split("\\.");
		System.out.println(test1.length);
		
		
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((str == null) ? 0 : str.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this.str.equals(obj.toString())) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}
	
	@Override
	public String toString() {
		return new String(this.str);
	}
}
