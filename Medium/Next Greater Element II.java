/*
 * LeetCode 503: Next Greater Element II
 *
 * Problem:
 * Given a circular integer array nums, return the next greater
 * number for every element.
 *
 * The next greater number is the first number greater than the
 * current number while moving to the right.
 *
 * Since the array is circular, after the last element we continue
 * from the first element.
 *
 * If no greater number exists, return -1.
 *
 * Example 1:
 * Input:  nums = [1,2,1]
 * Output: [2,-1,2]
 *
 * Example 2:
 * Input:  nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 *
 * Approach:
 * 1. Use a stack to store indices whose next greater element
 *    has not been found yet.
 * 2. Traverse the array twice to simulate circular traversal.
 * 3. Use i % n to get the actual index.
 * 4. While the current number is greater than the number at the
 *    stack's top index, it is the next greater element.
 * 5. Put the current value in the answer.
 * 6. Push indices only during the first traversal.
 *
 * Why Stack?
 * The stack keeps elements in decreasing order.
 * When a greater element is found, we can resolve multiple
 * previous elements efficiently.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            int index = i % n;

            while (!stack.isEmpty() &&
                   nums[stack.peek()] < nums[index]) {

                int previousIndex = stack.pop();
                answer[previousIndex] = nums[index];
            }

            if (i < n) {
                stack.push(index);
            }
        }

        return answer;
    }
}
