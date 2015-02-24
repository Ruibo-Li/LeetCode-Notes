/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode sp = head;
        ListNode fp = head;
        while(fp.next!=null&&fp.next.next!=null) {
            fp = fp.next.next;
            sp = sp.next;
        }
        ListNode head2 = sp.next;
        sp.next = null;
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(head2);
        return merge(h1,h2);
    }
    public ListNode merge(ListNode n1,ListNode n2) {
        ListNode pre = new ListNode (0);
        ListNode p = pre;
        while(n1!=null&&n2!=null) {
            if(n1.val<n2.val) {
                p.next = n1;
                n1 = n1.next;
            }
            else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }
        if(n1!=null) p.next = n1;
        if(n2!=null) p.next = n2;
        return pre.next;
    }
}