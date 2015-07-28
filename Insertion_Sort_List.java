/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode cur = head.next;
        while(cur!=null) {
            int tmp = cur.val;
            ListNode p = head;
            while(p!=cur&&p.val<cur.val)
                p = p.next;
            ListNode q = p;
            int pre = q.val;
            while(q!=cur) {
                int qtmp = q.next.val;
                q.next.val = pre;
                pre = qtmp;
                q = q.next;
            }
            p.val = tmp;
            cur = cur.next;
        }
        return head;
    }
}