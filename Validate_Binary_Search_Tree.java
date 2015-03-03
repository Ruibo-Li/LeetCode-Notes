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
    public boolean isValidBST(TreeNode root) {
        List<Integer> pre = new ArrayList<Integer> ();
        pre.add(null);
        return helper(root,pre);
    }
    public boolean helper(TreeNode root,List<Integer> pre){
        if(root==null) return true;
        boolean left = helper(root.left,pre);
        if(pre.get(0)!=null&&pre.get(0)>=root.val) return false;
        pre.set(0,root.val);
        boolean right = helper(root.right,pre);
        return left&&right;
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
    public boolean isValidBST(TreeNode root) {
        return helper(root,(long)(Integer.MIN_VALUE)-1,(long)(Integer.MAX_VALUE)+1);
    }
    public boolean helper(TreeNode root,long min,long max){
        if(root==null) return true;
        if(root.val<=min||root.val>=max) return false;
        return helper(root.left,min,(long)(root.val))&&helper(root.right,(long)(root.val),max);
    }
}