class TrieNode {
    char c;
    boolean isLeaf;
    HashMap <Character, TrieNode> children = new HashMap <Character, TrieNode> ();
    // Initialize your data structure here.
    
    public TrieNode() {}
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode t = this.root;
        for(int i=0;i<word.length();i++) {
            char cur = word.charAt(i);
            HashMap <Character, TrieNode> map = t.children;
            if(!map.containsKey(cur)) {
                TrieNode newNode = new TrieNode();
                map.put(cur,newNode);
            }
            t = map.get(cur);
            if(i==word.length()-1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t= searchNode(word);
        return t!=null && t.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchNode(prefix)!=null;
    }
    
    private TrieNode searchNode(String word) {
        HashMap <Character, TrieNode> map = root.children;
        TrieNode t = null;
        for(int i=0;i<word.length();i++) {
            char cur = word.charAt(i);
            if(!map.containsKey(cur))
                return null;
            t = map.get(cur);
            map = t.children;
        }
        return t;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");