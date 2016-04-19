package practice.composite;

public interface VariableComponent {
	public void addComponet(VariableComponent vc);
	
	public void removeComponent(VariableComponent vc);
	
	public VariableComponent getChild(int childNum);
	
	public void variableOperation();
}
