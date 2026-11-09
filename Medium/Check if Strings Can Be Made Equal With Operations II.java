
/*
 * LeetCode 2840: Check if Strings Can Be Made Equal With Operations II
 *
 * Approach: Frequency Counting
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean checkStrings(String s1, String s2) {

        int[][] freq = new int[2][26];

        // Count characters at even and odd indices in s1.
        for (int i = 0; i < s1.length(); i++) {
            freq[i % 2][s1.charAt(i) - 'a']++;
        }

        // Subtract character frequencies from s2.
        for (int i = 0; i < s2.length(); i++) {
            freq[i % 2][s2.charAt(i) - 'a']--;
        }

        // Both parity groups must have matching frequencies.
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 26; j++) {
                if (freq[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
