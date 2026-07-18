// Problem: 1394. Find Lucky Integer in an Array
// Approach: Count frequency of each number.
// A number is lucky if frequency == value.
// Return the largest such number, else -1.
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class Solution {
    public int findLucky(int[] arr) {

        // frequency array (1 to 500 range)
        int[] freq = new int[501];

        // Step 1: count frequency
        for (int num : arr) {
            freq[num]++;
        }

        int result = -1;

        // Step 2: check lucky numbers
        for (int i = 1; i <= 500; i++) {
            if (freq[i] == i) {
                result = i; // store largest lucky number
            }
        }

        return result;
    }
}
