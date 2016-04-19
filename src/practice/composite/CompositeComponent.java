package practice.composite;

import java.util.ArrayList;

public class CompositeComponent implements VariableComponent{
	ArrayList<VariableComponent> list = new ArrayList<>();
	
	@Override
	public void addComponet(VariableComponent vc) {
		System.out.println("Adding");
		list.add(vc);
	}

	@Override
	public void removeComponent(VariableComponent vc) {
		System.out.println("Removing");
		list.remove(vc);
	}

	@Override
	public VariableComponent getChild(int childNum) {
		System.out.println("getChild");
		return list.get(childNum);
	}

	@Override
	public void variableOperation() {
		System.out.println("variableOperation on each member");
		for(VariableComponent vc: list)
			vc.variableOperation();
	}

}
