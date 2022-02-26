import java.util.HashMap;

class Trie {

    private Trie root;
    char val;
    HashMap<Character, Trie> map = new HashMap<>();
    boolean isEnd;

    public Trie() {}

    public Trie(char x) {
        this.val = x;
    }

    public void insert(String word) {
        if (this.root == null) this.root = new Trie();
        Trie curr = root;
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            curr.map.putIfAbsent(x, new Trie(x));
            curr = curr.map.get(x);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = searchHelper(word);
        return curr != null && curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie curr = searchHelper(prefix);
        return curr != null;
    }

    private Trie searchHelper(String word) {
        if (this.root == null) return null;
        Trie curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            if (! curr.map.containsKey(x)) return null;
            else curr = curr.map.get(x);
        }
        return curr;
    }
}
