package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Monil on 4/19/16.
 *
 * http://www.programcreek.com/2013/01/leetcode-path-sum/
 */
public class PathSum {

    public boolean hasPathSumBFS(TreeNode root, int sum) {
        if(root == null) return false;

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();

        nodes.add(root);
        values.add(root.val);

        while(!nodes.isEmpty()){
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();

            if(curr.left == null && curr.right == null && sumValue==sum){
                return true;
            }

            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue+curr.left.val);
            }

            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue+curr.right.val);
            }
        }

        return false;
    }

    public boolean hasPathSumDFS(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && (root.left == null && root.right == null))
            return true;

        return hasPathSumDFS(root.left, sum - root.val)
                || hasPathSumDFS(root.right, sum - root.val);
    }

    /**
     *
     * http://www.programcreek.com/2014/05/leetcode-path-sum-ii-java/
     */
    public List<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;

        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(root.val);
        dfs(root, sum-root.val, result, l);
        return result;
    }

    public void dfs(TreeNode t, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l){
        if(t.left==null && t.right==null && sum==0){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(l);
            result.add(temp);
        }

        //search path of left node
        if(t.left != null){
            l.add(t.left.val);
            dfs(t.left, sum-t.left.val, result, l);
            l.remove(l.size()-1);
        }

        //search path of right node
        if(t.right!=null){
            l.add(t.right.val);
            dfs(t.right, sum-t.right.val, result, l);
            l.remove(l.size()-1);
        }
    }
}
