public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            if(node==null) node = new TrieNode();
            if(node.next[word.charAt(i)-'a']==null)
                node.next[word.charAt(i)-'a'] = new TrieNode();
            node = node.next[word.charAt(i)-'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            if(node==null) return false;
            node = node.next[word.charAt(i)-'a'];
        }
        if(node==null) return false;
        return node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++) {
            if(node==null) return false;
            node = node.next[prefix.charAt(i)-'a'];
        }
        if(node==null) return false;
        for(int i=0; i<26; i++) {
            if(node.next[i]!=null) return true;
        }
        return false;
    }
}