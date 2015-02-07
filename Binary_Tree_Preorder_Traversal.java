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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList();
        pt(root,al);
        return al;
    }
    public void pt(TreeNode root,List<Integer> al){
        if(root!=null) al.add(root.val);
        if(root!=null&&root.left!=null) pt(root.left,al);
        if(root!=null&&root.right!=null) pt(root.right,al);
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList <Integer> ();
        preorder(res,root);
        return res;
    }
    public void preorder(List<Integer> res,TreeNode root) {
        if(root==null) return;
        res.add(root.val);
        preorder(res,root.left);
        preorder(res,root.right);
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
public class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList <Integer> ();
        if(root==null) return res;
        Stack <TreeNode> st = new Stack <TreeNode> ();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode cur = st.pop();
            res.add(cur.val);
            if(cur.right!=null)
                st.push(cur.right);
            if(cur.left!=null)
                st.push(cur.left);
        }
        return res;
    }
}