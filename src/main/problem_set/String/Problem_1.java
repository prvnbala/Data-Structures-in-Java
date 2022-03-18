package main.problem_set.String;/*
https://leetcode.com/problems/counting-words-with-a-given-prefix/
 */

public class Problem_1 {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        int n = pref.length();
        for (String word : words) {
            if (word.length() >= pref.length()) {
                if (word.substring(0, n).equals(pref)) {
                    count++;
                }
            }
        }
        return count;
    }
}
