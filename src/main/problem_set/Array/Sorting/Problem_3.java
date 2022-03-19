/*
Given an array A of non-negative integers, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.
 */

package main.problem_set.Array.Sorting;

import java.util.*;

public class Problem_3 {
    public String largestNumber(final List<Integer> A) {
        List<String> temp = new ArrayList<>();
        for (Integer x : A) temp.add(String.valueOf(x));
        temp.sort((o1, o2) -> (o2+o1).compareTo(o1+o2));
        String ans = String.join("", temp);
        return ans.charAt(0) == '0' ? "0" : ans.toString();
    }

    public static void main(String[] args) {
        Problem_3 problem3 = new Problem_3();

        Integer[] inp1 = {3, 30, 34, 5, 9};
        List<Integer> test1 = new ArrayList<>(Arrays.asList(inp1));

        System.out.println(problem3.largestNumber(test1));

        Integer[] inp2 = {0, 0, 0, 0};
        List<Integer> test2 = new ArrayList<>(Arrays.asList(inp2));

        System.out.println(problem3.largestNumber(test2));
    }
}