/*
    LeetCode 3 - Longest Substring Without Repeating Characters

    Problem:
    --------
    Given a string s, find the length of the longest substring
    without repeating characters.

    Example 1:
    Input:  s = "abcabcbb"
    Output: 3

    Example 2:
    Input:  s = "bbbbb"
    Output: 1

    Example 3:
    Input:  s = "pwwkew"
    Output: 3

    Approach:
    ---------
    Use the Sliding Window technique.

    1. Use two pointers: left and right.
    2. Move right to expand the window.
    3. Store the frequency of each character.
    4. If a character appears more than once, move left
       until the window has no duplicate characters.
    5. Update the maximum window length.

    Example:
    "abcabcbb"

    Window:
    abc -> length 3
    Next 'a' creates duplicate
    Move left until duplicate is removed.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[128];

        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right)]++;

            while (freq[s.charAt(right)] > 1) {
                freq[s.charAt(left)]--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
