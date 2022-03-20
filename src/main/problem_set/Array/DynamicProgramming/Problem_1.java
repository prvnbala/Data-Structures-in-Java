package main.problem_set.Array.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given a M x N grid A of integers,
find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Return the minimum sum of the path.
NOTE: You can only move either down or right at any point in time.
 */
public class Problem_1 {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int left = j - 1 >= 0 ? A.get(i).get(j - 1) : Integer.MAX_VALUE;
                int top  = i - 1 >= 0 ? A.get(i - 1).get(j) : Integer.MAX_VALUE;
                int curr = A.get(i).get(j);
                A.get(i).set(j, curr + Math.min(left, top));
            }
        }

        return A.get(m-1).get(n-1);
    }

    public static void main(String[] args) {
        Problem_1 p1 = new Problem_1();

        int[][] inp1 = { {1, 3, 2}, {4, 3, 1}, {5, 6, 1} };
        int[][] inp2 = { {1, -3, 2}, {2, 5, 10}, {5, -5, 1} };

        ArrayList<ArrayList<Integer>> test1 = new ArrayList<>();

        for(int[] a : inp2) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int x : a) {
                temp.add(x);
            }
            test1.add(temp);
        }

        System.out.println(p1.minPathSum(test1));

    }
}
