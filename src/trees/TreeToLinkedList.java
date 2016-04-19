package trees;

import java.util.Stack;

/**
 * Created by Monil on 4/19/16.
 *
 * http://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/
 */
public class TreeToLinkedList {

        public void flatten(TreeNode root) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode p = root;

            while(p != null || !stack.empty()){

                if(p.right != null){
                    stack.push(p.right);
                }

                if(p.left != null){
                    p.right = p.left;
                    p.left = null;
                }else if(!stack.empty()){
                    TreeNode temp = stack.pop();
                    p.right=temp;
                }

                p = p.right;
            }
        }
}
