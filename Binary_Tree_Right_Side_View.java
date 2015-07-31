/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root==null)
            return res;
        res.add(root.val);
        helper(root, 1, res);
        return res;
    }
    public void helper(TreeNode root, int level, List<Integer> res) {
        if(level>res.size())
            res.add(root.val);
        if(root.right!=null)
            helper(root.right, level+1, res);
        if(root.left!=null)
            helper(root.left, level+1, res);
    }
}