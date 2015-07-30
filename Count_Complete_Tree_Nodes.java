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
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        TreeNode tmp = root.left;
        int ln = 1;
        while(tmp!=null) {
            tmp = tmp.left;
            ln++;
        }
        tmp = root.right;
        int rn = 1;
        while(tmp!=null) {
            tmp = tmp.right;
            rn++;
        }
        if(ln==rn)
            return (1<<ln)-1;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}