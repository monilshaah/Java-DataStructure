package practice.composite;

public class Client {
	public static void main(String[] args) {
		VariableComponent string = new StringComponent();
		string.variableOperation();
		
		VariableComponent integer = new IntegerComponent();
		integer.addComponet(string);
		integer.removeComponent(string);
		integer.getChild(0);
		integer.variableOperation();
		
		VariableComponent cc = new CompositeComponent();
		cc.addComponet(string);
		cc.addComponet(integer);
		cc.variableOperation();
		
	}
}
