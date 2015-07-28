/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return;
        ListNode s = head;
        ListNode f = head;
        while(f!=null&&f.next!=null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode rehead = s.next;
        s.next = null;
        ListNode cur = head;
        ListNode curr = reverse(rehead);
        while(curr!=null) {
            ListNode tmp = cur.next;
            cur.next = curr;
            ListNode tmpr = curr.next;
            curr.next = tmp;
            cur = tmp;
            curr = tmpr;
        }
    }
    public ListNode reverse(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode cur = head.next;
        ListNode end = head;
        while(cur!=null) {
            end.next = cur.next;
            cur.next = prehead.next;
            prehead.next = cur;
            cur = end.next;
        }
        return prehead.next;
    }
}