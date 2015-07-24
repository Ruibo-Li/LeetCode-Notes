/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode s = head;
        ListNode f = head;
        while(f!=null&&f.next!=null) {
            f = f.next.next;
            s = s.next;
        }
        ListNode sechead;
        if(f!=null)
            sechead = s.next;
        else
            sechead = s;
        ListNode presechead = new ListNode(0);
        presechead.next = sechead;
        ListNode end = sechead;
        ListNode cur = sechead.next;
        while(cur!=null) {
            ListNode tmp = cur.next;
            ListNode prenext = presechead.next;
            presechead.next = cur;
            cur.next = prenext;
            end.next = tmp;
            cur = tmp;
        }
        s = head;
        f = presechead.next;
        while(f!=null) {
            if(s.val!=f.val)
                return false;
            f = f.next;
            s = s.next;
        }
        return true;
    }
}