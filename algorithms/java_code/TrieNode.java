class TrieNode {
    public TrieNode[] next;
    public boolean isWord;
    public boolean path;
    public int tmp;
    // Initialize your data structure here.
    public TrieNode() {
        isWord = false;
        next = new TrieNode[26];
        tmp = -1;
    }
}