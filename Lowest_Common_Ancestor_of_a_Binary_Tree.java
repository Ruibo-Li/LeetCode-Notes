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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root==p||root==q)
            return root;
        TreeNode L = lowestCommonAncestor(root.left, p, q);
        TreeNode R = lowestCommonAncestor(root.right, p, q);
        if(L!=null&&R!=null)
            return root;
        if(L!=null)
            return L;
        else
            return R;
    }
}