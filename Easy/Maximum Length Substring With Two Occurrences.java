/**
 * LeetCode 3090: Maximum Length Substring With Two Occurrences
 *
 * Approach:
 * Use the sliding window technique to find the longest substring
 * containing at most two occurrences of each character.
 *
 * Expand the window by moving the right pointer.
 * If any character appears more than twice, shrink the window
 * from the left until the condition is satisfied.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'a']++;

            while (freq[ch - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
