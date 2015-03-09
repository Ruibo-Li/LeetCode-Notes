/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        List<Integer> tmp = new ArrayList<Integer> ();
        helper(root,sum,0,res,tmp);
        return res;
    }
    public void helper(TreeNode root,int sum,int cursum,List<List<Integer>> res,List<Integer> tmp){
        if(root==null) return;
        cursum += root.val;
        tmp.add(root.val);
        if(root.right==null&&root.left==null){
            if(cursum==sum) res.add(new ArrayList<Integer> (tmp));
            return;
        }
        else{
            List<Integer> tmp2 = new ArrayList<Integer> (tmp);
            if(root.left!=null) helper(root.left,sum,cursum,res,tmp);
            if(root.right!=null) helper(root.right,sum,cursum,res,tmp2);
            return;
        }
    }
}