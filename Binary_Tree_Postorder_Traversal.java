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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList();
        pt(root,al);
        return al;
    }
    public void pt(TreeNode root,List<Integer> al){
        
        if(root!=null&&root.left!=null) pt(root.left,al);
        if(root!=null&&root.right!=null) pt(root.right,al);
        if(root!=null) al.add(root.val);
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList <Integer> ();
        if(root==null) return res;
        Stack <TreeNode> st = new Stack <TreeNode> ();
        st.push(root);
        TreeNode pre = null;
        while(!st.isEmpty()) {
            TreeNode cur = st.peek();
            if((cur.left==null&&cur.right==null)||(pre!=null&&(pre==cur.left||pre==cur.right))) {
                TreeNode p = st.pop();
                res.add(p.val);
                pre = p;
            }
            else {
                if(cur.right!=null) 
                    st.push(cur.right);
                if(cur.left!=null)
                    st.push(cur.left);
            }
        }
        return res;
    }
}