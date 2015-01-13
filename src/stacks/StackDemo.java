package stacks;

public class StackDemo {
	public static void main(String[] args) {
		System.out.println("Stack demo...");
		StackArray stack = new StackArray(50);
		stack.push('1');
		stack.push('2');
		stack.push('3');
		stack.push('4');
		stack.push('5');
		
		System.out.println("Top of stack: "+stack.peek());
		
		while(!stack.isEmpty()) {
			char elem = stack.pop();
			System.out.println(elem);
		}
	}
}
