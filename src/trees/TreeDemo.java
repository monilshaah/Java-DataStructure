package trees;

public class TreeDemo {
	public static void main(String[] args) {
		/*Tree btree = new Tree();
		
		btree.insert(50);
		btree.insert(30);
		btree.insert(70);
		btree.insert(25);
		btree.insert(80);
		btree.insert(40);
		btree.insert(60);
		btree.insert(75);
		btree.insert(78);*/
		
		/*if (btree.find(25) != null) 
			System.out.println("25 found!!!");
		else
			System.out.println("Not found!!!");
		
		System.out.println("Inorder Traverse::");
		btree.traverse(1);
//		System.out.println("Preorder Traverse::");
//		btree.traverse(2);
//		System.out.println("Postorder Traverse::");
//		btree.traverse(3);
		
		TreeNode del = btree.delete(30);*/
		
		/*System.out.println("Inorder Traverse::");
		btree.traverse(1);
		
		Tree mTree = btree.mirrorTree();
		
		System.out.println("Inorder Traverse::mTree");
		mTree.traverse(1);
		mTree.traverse(2);*/
		
		int[] inOrder = {80,78,75,70,60,50,40,30,25};
		int[] preOrder = {50, 70, 80, 75, 78, 60, 30, 40,25};
		Tree tree = Tree.buildTree(inOrder, preOrder);
		tree.traverse(1);
	}
}
