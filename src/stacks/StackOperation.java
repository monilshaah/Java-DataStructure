package stacks;

import java.util.Stack;

public class StackOperation {
	public String doRev(String input) {
		StackArray stack = new StackArray(input.length());
		for (int i=0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}
		String output = "";
		while(!stack.isEmpty()) {
			output = output + stack.pop();
		}
		return output;
	}
	
	public void checkDelimiter(String input) {
//		StackArray stack = new StackArray(input.length());
		Stack<String> stack = new Stack<String>();
		boolean error = false;
		char errorCh = ' ';
		int errorPos = -1;
		for (int i=0; i < input.length(); i++) {
			String ch = input.charAt(i)+"";
			switch (ch) {
				case "(": 	
				case "{":	
				case "[": 	//stack.push(ch);
							stack.push(ch+"");
							break;
				case ")":
				case "}":
				case "]":	if (!stack.isEmpty()) {
								String stackCh =  stack.pop();
								if ((ch == ")" && stackCh != "(") || 
									(ch == "}" && stackCh != "{") ||
									(ch == "]" && stackCh != "[")) {
									System.out.print("Error "+ch+" at ");
									System.out.println(i+1);
								} 
							} else {
								System.out.print("Error "+ch+" at ");
								System.out.println(i+1);
							}
							break;	
				default:	break;
			}
		}
		if (!stack.isEmpty()) {
				System.out.println("No closing delimiter for "+stack.pop());
		}	
	}
}
