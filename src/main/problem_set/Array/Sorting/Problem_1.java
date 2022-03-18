/*
Given an array of integers A,
find and return the minimum value of | A [ i ] - A [ j ] |
where i != j and |x| denotes the absolute value of x.

beware : |5 - (-5)| = 10
 */

package main.problem_set.Array.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Problem_1 {
    public int solve(ArrayList<Integer> A) {
        int minDiff = Integer.MAX_VALUE;
        Collections.sort(A);
        for (int i = 1; i < A.size(); i++) {
            minDiff = Math.min(minDiff, A.get(i) - A.get(i - 1));
        }
        return minDiff;
    }
}


class Application1 {
    public static void main(String[] args) {
        Problem_1 problem1 = new Problem_1();
        Integer[] inp1 = {-5, 0, 5};
        ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(inp1));
        System.out.println(problem1.solve(test1));
    }
}
