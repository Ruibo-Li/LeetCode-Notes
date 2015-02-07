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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode add1 = l1;
        ListNode add2 = l2;
        int c = 0;
        ListNode start = new ListNode(0);
        ListNode cur = start;
        while(add1!=null&&add2!=null){
            cur.next = new ListNode((add1.val+add2.val+c)%10);
            c = (add1.val+add2.val+c)/10;
            add1 = add1.next;
            add2 = add2.next;
            cur = cur.next;
        }
        while(add1!=null){
            cur.next = new ListNode((add1.val+c)%10);
            c = (add1.val+c)/10;
            add1 = add1.next;
            cur = cur.next;
        }
        while(add2!=null){
            cur.next = new ListNode((add2.val+c)%10);
            c = (add2.val+c)/10;
            add2 = add2.next;
            cur = cur.next;
        }
        if(c!=0) cur.next = new ListNode(c);
        return start.next;
    }
}