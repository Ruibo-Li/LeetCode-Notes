/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(depth(root.left)-depth(root.right))>1) return false;
        return isBalanced(root.right)&&isBalanced(root.left);
    }
    public int depth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(depth(root.left),depth(root.right));
    }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if(helper(root,0)==-1) return false;
        return true;
    }
    public int helper(TreeNode root,int level) {
        if(root==null) return level;
        int l,r;
        if(root.left!=null)
            l = helper(root.left,level+1);
        else
            l = level;
        if(root.right!=null)
            r = helper(root.right,level+1);
        else
            r = level;
        if(l==-1||r==-1||Math.abs(l-r)>1) 
            return -1;
        return Math.max(l,r);
    }
}