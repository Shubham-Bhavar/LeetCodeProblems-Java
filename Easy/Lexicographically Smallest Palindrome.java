
/*
 * LeetCode 2697 - Lexicographically Smallest Palindrome
 *
 * Difficulty: Easy
 * Approach: Two Pointers + Greedy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) - for the character array
 */

class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char smaller = (char) Math.min(chars[left], chars[right]);

            chars[left] = smaller;
            chars[right] = smaller;

            left++;
            right--;
        }

        return new String(chars);
    }
}
