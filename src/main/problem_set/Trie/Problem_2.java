package main.problem_set.Trie;

import main.data_structure_implementation.Trie;

import java.util.Arrays;

/*
Given a set of words, find the shortest prefix for each word that uniquely identifies it
 */
public class Problem_2 {
    public String findUniquePrefix(Trie trie, String word) {
        StringBuilder sb = new StringBuilder();
        Trie curr = trie.getRoot();

        for(char x : word.toCharArray()) {
            curr = curr.getMap().get(x);
            sb.append(curr.getVal());
            if(curr.getCount() == 1) {
                break;
            }
        }
        return sb.toString();
    }


    public String[] findUniquePrefix(String[] words) {
        String[] ans = new String[words.length];

        Trie trie = new Trie();
        for(String word:words) {
            trie.insert(word);
        }

        for(int i = 0; i < ans.length; i++) {
            ans[i] = findUniquePrefix(trie, words[i]);
        }
        return ans;
    }


    //Application code for testing
    public static void main(String[] args) {
        Problem_2 p2 = new Problem_2();
        String[] words = {"arun", "arash", "yash", "rahul", "raha"};
        System.out.println(Arrays.toString(p2.findUniquePrefix(words)));
    }
}


