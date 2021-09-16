/*
* A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

* Implement the Trie class:
*   Trie() Initializes the trie object.
*   void insert(String word) Inserts the string word into the trie.
*   boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
*   boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix "prefix", and false otherwise.
* */

class Trie {
    private boolean isEnd;
    private final Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
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
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie temp = this;

        for (int i=0; i<word.length(); i++) {
            if (temp.next[word.charAt(i) - 'a'] != null)
                temp = temp.next[word.charAt(i) - 'a'];
            else
                return false;
        }

        return temp.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie temp = this;

        for (int i=0; i<prefix.length(); i++) {
            if (temp.next[prefix.charAt(i) - 'a'] != null)
                temp = temp.next[prefix.charAt(i) - 'a'];
            else
                return false;
        }

        return true;
    }
}

/*
  Your Trie object will be instantiated and called as such:
  Trie obj = new Trie();
  obj.insert(word);
  boolean param_2 = obj.search(word);
  boolean param_3 = obj.startsWith(prefix);
 */
