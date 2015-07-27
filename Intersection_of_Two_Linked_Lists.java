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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        int la = 0;
        ListNode cur = headA;
        while(cur!=null) {
            la++;
            cur = cur.next;
        }
        int lb = 0;
        cur = headB;
        while(cur!=null) {
            lb++;
            cur = cur.next;
        }
        ListNode shortl;
        ListNode longl;
        int llen;
        int slen;
        if(la>lb) {
            shortl = headB;
            slen = lb;
            longl = headA;
            llen = la;
        }
        else {
            shortl = headA;
            slen = la;
            longl = headB;
            llen = lb;
        }
        for(int i=0;i<llen-slen;i++) 
            longl = longl.next;
        while(longl!=shortl&&longl!=null&&shortl!=null) {
            longl = longl.next;
            shortl = shortl.next;
        }
        if(longl==null)
            return null;
        return longl;
    }
}