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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode n1 = head;
        ListNode n2 = head.next;
        ListNode newhead = head.next;
        ListNode con = null;
        while(n1!=null&&n2!=null){
            if(con!=null) con.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            con = n1;
            n1 = n1.next;
            if(n1!=null) n2 = n1.next;
        }
        return newhead;
    }
}