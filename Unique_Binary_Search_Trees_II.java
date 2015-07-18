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
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    public List<TreeNode> dfs(int l, int r) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if(l>r) {
            res.add(null);
            return res;
        }
        for(int i=l;i<=r;i++) {
            List<TreeNode> ltrees = dfs(l, i-1);
            List<TreeNode> rtrees = dfs(i+1, r);
            for(int j=0;j<ltrees.size();j++)
                for(int k=0;k<rtrees.size();k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = ltrees.get(j);
                    root.right = rtrees.get(k);
                    res.add(root);
                }
        }
        return res;
    }
}