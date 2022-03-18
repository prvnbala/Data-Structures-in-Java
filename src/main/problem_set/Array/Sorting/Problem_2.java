/*
Given an array of integers A of size N where N is even.

Divide the array into two subsets such that

1.Length of both subset is equal.
2.Each element of A occurs in exactly one of these subset.
Magic number = sum of absolute difference of corresponding elements of subset.

Note: You can reorder the position of elements within the subset to find the value of the magic number.

For Ex:-
subset 1 = {1, 5, 1},
subset 2 = {1, 7, 11}
Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12
Return an array B of size 2,
where B[0] = maximum possible value of Magic number modulo 109 + 7,
B[1] = minimum possible value of a Magic number modulo 109 + 7.
 */
package main.problem_set.Array.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Problem_2 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int m = 1000 * 1000 * 1000 + 7;
        ArrayList<Integer> ans = new ArrayList<>();
        Collections.sort(A);
        long minMagic = 0;
        for (int i = 1; i < A.size(); i+=2) {
            minMagic = (minMagic + A.get(i) - A.get(i - 1)) % m;
        }

        long maxMagic = 0;
        int l = 0, r = A.size() - 1;
        while (l < r) {
            maxMagic = (maxMagic + A.get(r) - A.get(l)) % m;
            l++;
            r--;
        }
        ans.add((int) maxMagic);
        ans.add((int) minMagic);
        return ans;
    }


}

class Application2 {
    public static void main(String[] args) {
        Problem_2 problem2 = new Problem_2();
        Integer[] inp1 = {3, 11, -1, 5};
        ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(inp1));
        System.out.println(problem2.solve(test1));
    }
}


