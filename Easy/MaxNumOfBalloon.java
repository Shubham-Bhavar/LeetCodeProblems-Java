/**
 * Problem: Maximum Number of Balloons
 * Platform: LeetCode
 *
 * Description:
 * Find maximum number of times the word "balloon" can be formed
 * using characters of the given string.
 *
 * Approach:
 * - Count frequency of characters
 * - Check required characters for "balloon"
 * - Return minimum possible formation count
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        // count frequency
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        return Math.min(
            Math.min(freq['b' - 'a'], freq['a' - 'a']),
            Math.min(
                Math.min(freq['l' - 'a'] / 2, freq['o' - 'a'] / 2),
                freq['n' - 'a']
            )
        );
    }
}
