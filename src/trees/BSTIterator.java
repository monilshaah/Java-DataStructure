package trees;

import java.util.Stack;

/**
 * Created by Monil on 4/19/16.
 *
 * http://www.programcreek.com/2014/04/leetcode-binary-search-tree-iterator-java/
 *
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 */
public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }
}
