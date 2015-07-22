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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, preorder.length-1, preorder, 0, inorder.length-1, inorder);
    }
    public TreeNode build(int ps, int pe, int[] preorder, int is, int ie, int[] inorder) {
        if(pe<ps||ie<is)
            return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int i;
        for(i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[ps]) break;
        }
        root.left = build(ps+1, ps+i-is, preorder, is, i-1, inorder);
        root.right = build(ps+i-is+1, pe, preorder, i+1, ie, inorder);
        return root;
    }
}