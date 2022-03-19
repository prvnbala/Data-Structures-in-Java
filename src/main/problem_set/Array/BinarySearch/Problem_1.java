/* Given a sorted array of integers A where
every element appears twice except for one element which appears once,
find and return this single element that appears only once.
NOTE: Users are expected to solve this in O(log(N)) time.
 */

package main.problem_set.Array.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem_1 {
    public int solve(ArrayList<Integer> A) {
        int l = 0, r = A.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean isUnique = isUnique(A, mid);
            if (isUnique) {
                return A.get(mid);
            } else {
                int firstOccurrence = findFirstOccurrence(A, mid);
                if (firstOccurrence % 2 == 0) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }

    private int findFirstOccurrence(ArrayList<Integer> A, int mid) {
        if (mid == 0) return mid;
        else if(A.get(mid).equals(A.get(mid - 1))) return mid - 1;
        else return mid;
    }

    private boolean isUnique(ArrayList<Integer> A, int mid) {
        if (mid == 0) {
            if (A.get(mid).equals(A.get(mid + 1))) {
                return false;
            }
        } else if (mid == A.size() -1) {
            if (A.get(mid).equals(A.get(mid - 1))) {
                return false;
            }
        } else {
            if (A.get(mid).equals(A.get(mid - 1)) || A.get(mid).equals(A.get(mid + 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem_1 problem_1 = new Problem_1();

        Integer[] inp1 = {1, 2, 2, 3, 3};
        Integer[] inp2 = {1, 1, 2, 3, 3};
        Integer[] inp3 = {1, 1, 2, 2, 3};
        Integer[] inp4 = {13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110, 110, 117, 117, 120, 120, 123, 123, 124,
                124, 132, 132, 164, 164, 166, 166, 190, 190, 200, 200, 212, 212, 217, 217, 225, 225, 238, 238, 261,
                261, 276, 276, 347, 347, 348, 348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474, 474, 493, 493 };

        /*ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(inp1));
        ArrayList<Integer> test2 = new ArrayList<>(Arrays.asList(inp2));
        ArrayList<Integer> test3 = new ArrayList<>(Arrays.asList(inp3));*/
        ArrayList<Integer> test4 = new ArrayList<>(Arrays.asList(inp4));

        /*System.out.println(problem_1.solve(test1));
        System.out.println(problem_1.solve(test2));
        System.out.println(problem_1.solve(test3));*/
        System.out.println(problem_1.solve(test4));
    }
}