public class WordDictionary {
    
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    private TrieNode root = new TrieNode();
        

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++) {
            if(node.children[word.charAt(i)-'a']==null)
                node.children[word.charAt(i)-'a'] = new TrieNode();
            node = node.children[word.charAt(i)-'a'];
        }
        node.item = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word, 0, root);
    }
    
    public boolean match(String word, int k, TrieNode node) {
        if(k==word.length())
            return node.item!="";
        if(word.charAt(k)!='.') {
            return node.children[word.charAt(k)-'a']!=null && match(word, k+1, node.children[word.charAt(k)-'a']);
        }
        else {
            for(int i=0;i<node.children.length;i++) {
                if(node.children[i]!=null && match(word, k+1, node.children[i]))
                    return true;
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");