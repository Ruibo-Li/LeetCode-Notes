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
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode sp = head;
        ListNode fp = head;
        boolean cycle = false;
        while(sp.next!=null&&fp!=null&&fp.next!=null){
            fp = fp.next.next;
            sp = sp.next;
            if(fp==sp){
                cycle = true;
                break;
            }
        }
        if(cycle){
            fp = head;
            while(fp!=sp){
                fp = fp.next;
                sp = sp.next;
            }
            return sp;
        }
        return null;
    }
}