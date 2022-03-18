/*
Given an array of positive integers A and an integer B,
find and return first continuous subarray which adds to B.
If the answer does not exist return an array with a single element "-1".
First sub-array means the sub-array for which starting index in minimum.
 */

package main.problem_set.Array.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem_1 {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();

        int sum = 0, l = 0, r = 0;
        boolean found = false;
        while (l < A.size()) {
            System.out.println(sum);
            if (sum == B) {
                found = true;
                break;
            } else if (sum < B) {
                if(r < A.size()) sum += A.get(r++);
                else break;
            } else {
                sum -= A.get(l++);
            }
        }

        if (found) for (int i = l; i < r; i++) ans.add(A.get(i));
        else ans.add(-1);

        return ans;
    }
}

class Application {
    public static void main(String[] args) {
        Problem_1 problem_1 = new Problem_1();
        Integer[] inp1 = {1, 2, 3, 4, 5, 6};
        Integer[] inp2 = {1, 1000000000};
        Integer[] inp3 = {15, 2, 5, 6, 9};

        ArrayList<Integer> test1 = new ArrayList<Integer>(Arrays.asList(inp1));
        ArrayList<Integer> test2 = new ArrayList<Integer>(Arrays.asList(inp2));
        ArrayList<Integer> test3 = new ArrayList<Integer>(Arrays.asList(inp3));

        //System.out.println(problem_1.solve(test1, 6));
        //System.out.println(problem_1.solve(test2, 1000000000));
        System.out.println(problem_1.solve(test3, 7));
    }
}
