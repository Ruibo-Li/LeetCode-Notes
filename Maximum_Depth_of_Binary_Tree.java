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
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        LinkedList <TreeNode> queue = new LinkedList <TreeNode> ();
        queue.add(root);
        int lvl = 0;
        while(!queue.isEmpty()) {
            int num = queue.size();
            for(int i=0;i<num;i++) {
                TreeNode cur = queue.removeFirst();
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
            lvl++;
        }
        return lvl;        
    }
}