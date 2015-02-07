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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q!=null) return false;
        if(p!=null&&q==null) return false;
        if(p==null&&q==null) return true;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> queue1 = new LinkedList<TreeNode> ();
        LinkedList<TreeNode> queue2 = new LinkedList<TreeNode> ();
        queue1.add(p);
        queue2.add(q);
        while(!queue1.isEmpty()||!queue2.isEmpty()) {
            TreeNode cur1 = queue1.poll();
            TreeNode cur2 = queue2.poll();
            if(cur1==null&&cur2!=null) return false;
            if(cur1!=null&&cur2==null) return false;
            if(cur1==null&&cur2==null) continue;
            if(cur1.val!=cur2.val) return false;
            queue1.add(cur1.left);
            queue1.add(cur1.right);
            queue2.add(cur2.left);
            queue2.add(cur2.right);
        }
        return true;
    }
}