package trees;

public class TreeNode {
	private int nodeData;
	private TreeNode left;
	private TreeNode right;

	public TreeNode (int nodeData) {
		this.nodeData = nodeData; 
	}
	
	public int getNodeData() {
		return nodeData;
	}
	
	public void setNodeData(int nodeData) {
		this.nodeData = nodeData;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}
}
