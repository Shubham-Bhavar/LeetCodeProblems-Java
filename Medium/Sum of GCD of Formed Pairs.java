
/*
 * LeetCode 3867: Sum of GCD of Formed Pairs
 *
 * Problem:
 * Construct prefixGcd where each element is the GCD of
 * nums[i] and the maximum element from nums[0] to nums[i].
 * Sort prefixGcd and pair the smallest element with the
 * largest element. Return the sum of GCDs of all pairs.
 *
 * Approach:
 * Prefix Maximum + Sorting + Euclidean Algorithm
 *
 * Step-by-step Explanation:
 * 1. Maintain the maximum value seen so far.
 * 2. Calculate GCD of nums[i] and the prefix maximum.
 * 3. Store each GCD in the prefixGcd array.
 * 4. Sort the prefixGcd array.
 * 5. Use two pointers: one at the beginning and one
 *    at the end of the sorted array.
 * 6. Calculate GCD of both elements and add it to the sum.
 * 7. Move both pointers towards the center.
 * 8. If one middle element remains, ignore it.
 *
 * Time Complexity: O(n log n + n log M)
 * Space Complexity: O(n)
 * M = maximum value in nums.
 */

import java.util.Arrays;

class Solution {

    public long gcdSum(int[] nums) {

        int n = nums.length;

        int[] prefixGcd = new int[n];

        int max = 0;

        // Construct prefixGcd
        for (int i = 0; i < n; i++) {

            max = Math.max(max, nums[i]);

            prefixGcd[i] = gcd(nums[i], max);
        }

        // Sort the prefixGcd array
        Arrays.sort(prefixGcd);

        long sum = 0;

        // Pair smallest with largest
        int left = 0;
        int right = n - 1;

        while (left < right) {

            sum += gcd(prefixGcd[left], prefixGcd[right]);

            left++;
            right--;
        }

        return sum;
    }

    // Euclidean algorithm to calculate GCD
    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
