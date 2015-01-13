import stacks.StackOperation;


public class Test {
	
	public static void main(String[] args) {
		StackOperation stackOps = new StackOperation();
		String output = stackOps.doRev("monil");
		System.out.println(output);
		
		stackOps = new StackOperation();
		stackOps.checkDelimiter("a{b[c(d)e]f}g");
		stackOps.checkDelimiter("a{b[cd)e]f}g");
		stackOps.checkDelimiter("a{b[c(d)e]fg");
		
		int[] a = {1,2,3,,,};
		System.out.println(a.length);
		
	}
}
