package main.problem_set.Trie;

import StringUtil.StringUtil;
import main.data_structure_implementation.Trie;

/*
Given a list of words and a suffix, count all the words that have the given suffix. Return the count.
 */
public class Problem_3 {
    public int suffixCount(String[] words, String suffix) {
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(StringUtil.reverse(word));
        }

        int count = 0;

        if(trie.startsWith(StringUtil.reverse(suffix))) {
            char[] suffix_letters = StringUtil.reverse(suffix).toCharArray();
            Trie curr = trie.getRoot();
            for(char x: suffix_letters) {
                curr = curr.getMap().get(x);
            }
            count = curr.getCount();
        }

        return count;
    }

    public static void main(String[] args) {
        String[] words = {"armor", "armor", "rumor", "grape", "ape", "shape", "tribe", "bungee" };
        String suffix = "mor";
        Problem_3 p3 = new Problem_3();
        System.out.println(p3.suffixCount(words, suffix)); //3
    }
}
