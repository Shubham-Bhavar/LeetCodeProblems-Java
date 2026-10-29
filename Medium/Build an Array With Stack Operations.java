
/*
 * Problem: 1441. Build an Array With Stack Operations
 * Difficulty: Medium
 * Language: Java
 *
 * Approach:
 * 1. Read numbers from 1 to n.
 * 2. Push every number into the stack.
 * 3. If the number is not the next target element, pop it.
 * 4. Stop when all target elements are processed.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) auxiliary space
 * (Output list excluded)
 */

import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int index = 0;

        for (int num = 1; num <= n && index < target.length; num++) {
            result.add("Push");

            if (num == target[index]) {
                index++;
            } else {
                result.add("Pop");
            }
        }

        return result;
    }
}
