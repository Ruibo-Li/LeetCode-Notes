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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    public TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if(is>ie||ps>pe)
            return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int i;
        for(i=0;i<inorder.length;i++) {
            if(inorder[i]==postorder[pe])
                break;
        }
        int rightsize = ie-i;
        root.left = build(inorder, is, i-1, postorder, ps, pe-rightsize-1);
        root.right = build(inorder, i+1, ie, postorder, pe-rightsize, pe-1);
        return root;
    }
}