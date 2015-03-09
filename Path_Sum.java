/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        int cursum = 0;
        if(root==null) return false; 
        else return search(root,cursum,sum);
    }
    public boolean search(TreeNode root,int cursum,int sum){
        if(root!=null) cursum += root.val;
        if(root!=null&&root.left==null&&root.right==null&&cursum==sum) return true;
        else{
            boolean flag1 = false;
            boolean flag2 = false;
            if(root!=null&&root.left!=null) flag1 = search(root.left,cursum,sum);
            if(root!=null&&root.right!=null) flag2 = search(root.right,cursum,sum);
            return flag1||flag2;
        }
    }
}