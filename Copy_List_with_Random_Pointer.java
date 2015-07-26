/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        RandomListNode newhead = new RandomListNode(head.label);
        RandomListNode cur = head;
        RandomListNode newcur = newhead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        map.put(head, newhead);
        while(cur.next!=null) {
            newcur.next = new RandomListNode(cur.next.label);
            map.put(cur.next, newcur.next);
            cur = cur.next;
            newcur = newcur.next;
        }
        cur = head;
        while(cur!=null) {
            if(cur.random!=null)
                map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return newhead;
    }
}