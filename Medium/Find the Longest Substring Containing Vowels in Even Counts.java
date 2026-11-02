
/*
 * LeetCode 1371 - Find the Longest Substring Containing Vowels in Even Counts
 *
 * Difficulty: Medium
 * Approach: Bitmask + First Occurrence Array
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findTheLongestSubstring(String s) {
        int[] first = new int[32];

        java.util.Arrays.fill(first, -2);
        first[0] = -1;

        int mask = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case 'a': mask ^= 1; break;
                case 'e': mask ^= 2; break;
                case 'i': mask ^= 4; break;
                case 'o': mask ^= 8; break;
                case 'u': mask ^= 16; break;
            }

            if (first[mask] != -2) {
                maxLength = Math.max(maxLength, i - first[mask]);
            } else {
                first[mask] = i;
            }
        }

        return maxLength;
    }
}
