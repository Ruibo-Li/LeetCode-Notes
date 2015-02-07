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
    public List<Integer> inorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList <Integer> ();
        inorder(res,root);
        return res;
    }
    public void inorder(List <Integer> res,TreeNode root) {
        if(root==null) return;
        inorder(res,root.left);
        res.add(root.val);
        inorder(res,root.right);
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer> ();
        if(root==null) return res;
        Stack<TreeNode> st = new Stack<TreeNode> ();
        TreeNode cur = root;
        while(!st.isEmpty()||cur!=null){
            if(cur!=null){
                st.push(cur);
                cur = cur.left;
            }
            else{
                cur = st.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}