package main.data_structure_implementation;

import java.util.HashMap;

public class Trie {

    private Trie root;
    private char val;
    private HashMap<Character, Trie> map = new HashMap<>();
    boolean isEnd;
    private int count;


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
            curr.count++;
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

    public char getVal() {
        return val;
    }

    public HashMap<Character, Trie> getMap() {
        return map;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public int getCount() {
        return count;
    }

    public Trie getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "Trie{" +
                "val=" + val +
                ", count=" + count +
                '}';
    }
}

class Application {
    public static void main(String[] args) {
        Trie test = new Trie();
        test.insert("apple");
        System.out.println(test.search("apple"));   //true
        System.out.println(test.search("app"));     //false
        System.out.println(test.startsWith("app"));      //true
        test.insert("app");
        System.out.println(test.startsWith("app"));      //true

    }
}
