package stacks;

public class StackArray {
	private char[] stackArray;
	private int stackSize;
	private int top;
	
	public StackArray(int stackSize) {
		stackArray = new char[stackSize];
		this.stackSize = stackSize;
		top = -1;
	}
	
	public void push(char elem) {
		stackArray[++top] = elem;
	}
	
	public char pop() {
		return stackArray[top--];
	}
	
	public char peek() {
		return stackArray[top];
	}
	
	public boolean isFull() {
		return (top == stackSize-1);
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
}
