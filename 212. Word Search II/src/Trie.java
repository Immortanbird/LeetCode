class Trie {
    String word;
    boolean isEnd;
    final Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        word = "";
        isEnd = false;
        next = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie temp = this;

        for (int i=0; i<word.length(); i++) {
            if (temp.next[word.charAt(i) - 'a'] == null)
                temp.next[word.charAt(i) - 'a'] = new Trie();
            temp = temp.next[word.charAt(i) - 'a'];
        }

        temp.isEnd = true;
        temp.word = word;
    }
}