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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<String>();
        if(root==null)
            return res;
        find(root, res, new StringBuilder());
        return res;
    }
    public void find(TreeNode root, List<String> res, StringBuilder sb) {
        sb.append(root.val);
        if(root.left==null&&root.right==null) {
            res.add(sb.toString());
            return;
        }
        sb.append("->");
        if(root.left!=null) 
            find(root.left, res, new StringBuilder(sb));
        if(root.right!=null)
            find(root.right, res, new StringBuilder(sb));
    }
}