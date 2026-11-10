
/*
 * LeetCode 932. Beautiful Array
 *
 * Problem:
 * Generate a permutation of numbers from 1 to n
 * such that no middle element is the average
 * of two elements at different positions.
 *
 * Approach: Divide and Conquer
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] beautifulArray(int n) {

        List<Integer> result = new ArrayList<>();
        result.add(1);

        while (result.size() < n) {

            List<Integer> temp = new ArrayList<>();

            // Generate odd numbers
            for (int num : result) {
                int value = 2 * num - 1;

                if (value <= n) {
                    temp.add(value);
                }
            }

            // Generate even numbers
            for (int num : result) {
                int value = 2 * num;

                if (value <= n) {
                    temp.add(value);
                }
            }

            result = temp;
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
