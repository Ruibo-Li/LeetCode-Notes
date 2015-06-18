public class Solution {
    Set <String> res = new HashSet <String> ();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words)
            trie.insert(word);
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                dfs(visited, board, trie, "", i, j, m ,n);
        return new ArrayList(res);
    }
    
    public void dfs(boolean[][] visited, char[][] board, Trie trie, String str, int x, int y, int m, int n) {
        if(x<0||x>=m||y<0||y>=n)
            return;
        if(visited[x][y])
            return;
        str += board[x][y];
        if(!trie.startWith(str))
            return;
        if(trie.search(str))
            res.add(str);
        visited[x][y] = true;
        dfs(visited, board, trie, str, x+1, y, m ,n);
        dfs(visited, board, trie, str, x-1, y, m ,n);
        dfs(visited, board, trie, str, x, y+1, m ,n);
        dfs(visited, board, trie, str, x, y-1, m ,n);
        visited[x][y] = false;
    }
    
    class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private String item = "";
        public TrieNode() {}
    }
    
    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode node = root;
            for(int i=0;i<word.length();i++) {
                if(node.children[word.charAt(i)-'a']==null)
                    node.children[word.charAt(i)-'a'] = new TrieNode();
                node = node.children[word.charAt(i)-'a'];
            }
            node.item = word;
        }
        public boolean search(String word) {
            TrieNode node = root;
            for(int i=0;i<word.length();i++) {
                if(node.children[word.charAt(i)-'a']==null)
                    return false;
                node = node.children[word.charAt(i)-'a'];
            }
            return node.item.equals(word);
        }
        public boolean startWith(String word) {
            TrieNode node = root;
            for(int i=0;i<word.length();i++) {
                if(node.children[word.charAt(i)-'a']==null)
                    return false;
                node = node.children[word.charAt(i)-'a'];
            }
            return true;            
        }
    }
}