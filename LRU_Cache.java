public class LRUCache {
    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    int size;
    class Node {
        int key;
        int value;
        Node next;
        Node pre;
        public Node(int k, int v) {
            key = k;
            value = v;
            pre = null;
            next = null;
        }
    }
    public LRUCache(int capacity) {
        cache = new HashMap<Integer, Node>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        size = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public void tohead(Node n) {
        Node tmp = head.next;
        head.next = n;
        n.pre = head;
        n.next = tmp;
        tmp.pre = n;
    }
    
    public int get(int key) {
        Node n = cache.get(key);
        if(n!=null) {
            n.next.pre = n.pre;
            n.pre.next = n.next;
            tohead(n);
            return n.value;
        }
        else    
            return -1;
    }
    
    public void set(int key, int value) {
        Node n = cache.get(key);
        if(n!=null) {
            n.value = value;
            n.pre.next = n.next;
            n.next.pre = n.pre;
            cache.put(key, n);
            tohead(n);
        }
        else {
            if(cache.size()==size) {
                Node tmp = tail.pre;
                tmp.pre.next = tail;
                tail.pre = tmp.pre;
                cache.remove(tmp.key);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            tohead(newNode);
        }
    }
}