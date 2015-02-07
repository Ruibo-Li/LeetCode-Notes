/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode,UndirectedGraphNode> ();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode> ();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node,head);
        queue.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode neighbor:cur.neighbors){
                if(!hm.containsKey(neighbor))
                {
                    queue.add(neighbor);
                    UndirectedGraphNode newneighbor = new UndirectedGraphNode(neighbor.label);
                    hm.put(neighbor,newneighbor);
                }
                hm.get(cur).neighbors.add(hm.get(neighbor));
            }
        }
        return head;
    }
}