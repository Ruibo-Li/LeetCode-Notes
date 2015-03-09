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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null|m==n) return head;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        int count = 1;
        ListNode pre = prehead;
        while(count<m){
            pre = pre.next;
            count++;
        } 
        ListNode end = pre.next;
        ListNode cur = end.next;
        count = 0;
        while(count<n-m){
            ListNode tmp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            end.next = tmp;
            cur = tmp;
            count++;
        }
        return prehead.next;
    }
}