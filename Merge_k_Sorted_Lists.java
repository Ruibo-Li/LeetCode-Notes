/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists==null||lists.size()==0)return null;
        return helper(lists,0,lists.size()-1);
    }
    public ListNode helper(List<ListNode> lists,int l,int r){
        if(l<r){
            int mid = (l+r)/2;
            return merge(helper(lists,l,mid),helper(lists,mid+1,r));
        }
        return lists.get(l);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode head = new ListNode (0);
        ListNode pre = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                pre.next = l1;
                l1 = l1.next;
            }
            else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1!=null) pre.next = l1;
        if(l2!=null) pre.next = l2;
        return head.next;
    }
}