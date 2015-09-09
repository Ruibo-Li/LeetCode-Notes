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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode n = root;
        while(n!=null) {
            st.push(n);
            n = n.left;
        }
        while(k>0&&(!st.isEmpty()||n!=null)) {
            if(n!=null) {
                st.push(n);
                n = n.left;
            }
            else {
                n = st.pop();
                if(--k==0)
                    return n.val;
                n = n.right;
            }
        }
        return n.val;
    }
}