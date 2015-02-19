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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        if(head==null || head.next==null) return head;
        ListNode p = pre.next;
        while(p!=null) {
            if(pre.val==p.val) 
                pre.next = p.next;
            else
                pre = pre.next;
            p = p.next;
        }
        return head;
    }
}