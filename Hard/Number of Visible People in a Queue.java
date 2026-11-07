/*1944. Number of Visible People in a Queue

Difficulty: Hard
Topic: Monotonic Stack
Language: Java

Approach

Used a Monotonic Stack to calculate the number of people each person can see.

- Traverse the array from right to left.
- Remove all shorter people from the stack.
- Count each removed person as visible.
- If the stack is not empty, count the first taller person.
- Push the current person's height into the stack.

Complexity

- Time: O(n)
- Space: O(n)

Key Concepts

- Monotonic Stack
- Stack
- Array Traversal
- Greedy Approach*/

import java.util.*;

class Solution {
    public int[] canSeePersonsCount(int[] heights) {

        int n = heights.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   heights[i] > stack.peek()) {

                stack.pop();
                result[i]++;
            }

            if (!stack.isEmpty()) {
                result[i]++;
            }

            stack.push(heights[i]);
        }

        return result;
    }
}
