package trees;

public class Tree {
	private TreeNode root;
	
	public void insert(int nodeData) {
		TreeNode temp = new TreeNode(nodeData);
		if (root == null) {
			System.out.println("Setting root node "+nodeData);
			root = temp;
			return;
		}
		boolean isLeftChild = false;
		TreeNode current = root;
		TreeNode parent = root;
		while (current != null) {
			parent = current;
			if (current.getNodeData() > nodeData) {
				isLeftChild = true;
				current = current.getLeft();
			} else {
				isLeftChild = false;
				current = current.getRight();
			}
		}
		if (isLeftChild) {
			parent.setLeft(temp);
			System.out.println("Inserting "+nodeData+" left of "+parent.getNodeData());
		}
		else {
			parent.setRight(temp);
			System.out.println("Inserting "+nodeData+" right of "+parent.getNodeData());
		}
	}
	
	public TreeNode find(int key) {
		TreeNode current = root;
		while(current != null) {
			if (current.getNodeData() == key)
				break;
			if (current.getNodeData() > key) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		return current;
	}
	
	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			inorderTraverse(root);
			System.out.println();
			break;
		case 2:
			preorderTraverse(root);
			System.out.println();
			break;
		case 3:
			postorderTraverse(root);
			System.out.println();
			break;
		default:
			System.out.println("Invalid traverse type!!!");
		}
	}
	
	public void inorderTraverse(TreeNode current) {
		if (current != null) {
			inorderTraverse(current.getLeft());
			System.out.print(current.getNodeData()+" ");
			inorderTraverse(current.getRight());
		}
	}
	
	public void preorderTraverse(TreeNode current) {
		if (current != null) {
			System.out.print(current.getNodeData()+" ");
			preorderTraverse(current.getLeft());
			preorderTraverse(current.getRight());
		}
	}
	
	public void postorderTraverse(TreeNode current) {
		if (current != null) {
			postorderTraverse(current.getLeft());
			postorderTraverse(current.getRight());
			System.out.print(current.getNodeData()+" ");
		}
	}
	
	public TreeNode delete(int delKey) {
		TreeNode delNode = root;
		TreeNode parent = root;
		
		boolean isLeftChild = false;
		while(delNode != null) {
			if (delNode.getNodeData() == delKey)
				break;
			if (delNode.getNodeData() > delKey) {
				isLeftChild = true;
				parent = delNode;
				delNode = delNode.getLeft();
			} else {
				isLeftChild = false;
				parent = delNode;
				delNode = delNode.getRight();
			}
		}
		
		if (delNode == null)  // key not present in btree
			return null;
		if (delNode.getLeft() == null && delNode.getRight() == null) {		// leaf node
			if (isLeftChild)
				parent.setLeft(null);
			else
				parent.setRight(null);
		} else if (delNode.getRight() == null) {		// node with only left child
			if (delNode == root)
				root = delNode.getLeft();
			else if (isLeftChild) 
				parent.setLeft(delNode.getLeft());
			else
				parent.setRight(delNode.getLeft());
		} else if (delNode.getLeft() == null) {			// node with only right child
			if (delNode == root)
				root = delNode.getLeft();
			else if (isLeftChild)
				parent.setLeft(delNode.getRight());
			else 
				parent.setRight(delNode.getRight());
		}
		
		else {											// node with both children				
			TreeNode successor = getInorderSuccessor(delNode);
			if (delNode == root)
				root = successor;
			else if (isLeftChild)
				parent.setLeft(successor);
			else
				parent.setRight(successor);
			successor.setLeft(delNode.getLeft());
		}
		return delNode;
	}
	
	public TreeNode rootSuccessor() {
		return getInorderSuccessor(root);
	}
	
	public TreeNode getInorderSuccessor(TreeNode node) {
		TreeNode successorParent = node;
		TreeNode successor = node;
		TreeNode current = node.getRight();
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeft();
		}
		if (successor != node.getRight()) {
			successorParent.setLeft(successor.getRight());
			successor.setRight(node.getRight());
		}
		System.out.println("successor::"+successor.getNodeData());
		return successor;
	}
}
	
