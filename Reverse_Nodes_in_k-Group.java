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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k<=1) return head;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode pre = prehead;
        while(true){
            int count = 1;
            ListNode end = pre.next;
            if(end==null) break;
            while(count<k&&end.next!=null){
                end = end.next;
                count++;
            }
            if(count!=k) break;
            count = 1;
            end = pre.next;
            ListNode cur = end.next;
            while(count<k){
                ListNode tmp = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                end.next = tmp;
                cur = tmp;
                count++;
            }
            pre = end;
        }
        return prehead.next;
    }
}