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
        ListNode pre = new ListNode (0);
        pre.next = head;
        ListNode p = pre;
        ListNode q = head;
        if(head==null || head.next==null) return head;
        ListNode r = head.next;
        while(r!=null) {
            if(q.val==r.val) {
                while(r!=null&&q.val==r.val) {
                    q.next = r.next;
                    r = r.next;
                }
                p.next = r;
                if(r==null) break;
                q = r;
                r = r.next;
            } 
            else {
                r = r.next;
                q = q.next;
                p = p.next;
            }
        }
        return pre.next;
    }
}