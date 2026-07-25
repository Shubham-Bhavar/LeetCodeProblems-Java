/**
 * Problem: DI String Match
 * Platform: LeetCode
 *
 * Description:
 * Given a string s of 'I' and 'D', construct a permutation of [0..n]
 * such that:
 * - 'I' → increasing
 * - 'D' → decreasing
 *
 * Approach (Greedy):
 * - Maintain two pointers: low = 0, high = n
 * - If 'I' → assign low++
 * - If 'D' → assign high--
 * - Add remaining number at the end
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0, high = n;
        int[] result = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = low++;
            } else {
                result[i] = high--;
            }
        }

        result[n] = low; // last remaining number
        return result;
    }
}
