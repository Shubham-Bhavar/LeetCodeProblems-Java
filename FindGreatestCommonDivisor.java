/**
 * 🧠 Problem:
 * - Find smallest and largest element in nums
 * - Return their GCD
 *
 * 📥 Input:
 * nums = [2,5,6,9,10]
 *
 * 📤 Output:
 * 2
 *
 * ⚡ Approach:
 * - Traverse once → find min & max
 * - Apply Euclidean Algorithm for GCD
 *
 * ⏱ Time: O(n + log(max))
 * ⏱ Space: O(1)
 */

class Solution {
    public int findGCD(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // find min and max
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // compute gcd
        return gcd(min, max);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
