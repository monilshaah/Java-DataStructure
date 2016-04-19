package practice.composite;

public class IntegerComponent implements VariableComponent{
	int num = 10;

	@Override
	public void addComponet(VariableComponent vc) {
		System.out.println("Invalid Operation!");
		
	}

	@Override
	public void removeComponent(VariableComponent vc) {
		System.out.println("Invalid Operation!");
	}

	@Override
	public VariableComponent getChild(int childNUm) {
		System.out.println("Invalid Operation!");
		return null;
	}

	@Override
	public void variableOperation() {
		System.out.println("leaf::"+num);
	}
	
}
