package trees;

/**
 * Created by Monil on 4/19/16.
 *
 * http://www.programcreek.com/2014/07/leetcode-lowest-common-ancestor-of-a-binary-search-tree-java/
 *
 * http://www.programcreek.com/2014/07/leetcode-lowest-common-ancestor-of-a-binary-tree-java/
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode m = root;

        if(m.val > p.val && m.val < q.val){
            return m;
        }else if(m.val>p.val && m.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(m.val<p.val && m.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
