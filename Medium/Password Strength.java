/*
 * Question: Password Strength
 *
 * Calculate the password strength using these rules:
 *
 * - Each distinct lowercase letter: 1 point
 * - Each distinct uppercase letter: 2 points
 * - Each distinct digit: 3 points
 * - Each distinct special character (!, @, #, $): 5 points
 *
 * A character contributes points only once, even if it appears multiple times.
 *
 * Example:
 * Input:  "bbB11#"
 * Output: 11
 *
 * Distinct characters:
 * 'b' -> 1 point
 * 'B' -> 2 points
 * '1' -> 3 points
 * '#' -> 5 points
 *
 * Total = 1 + 2 + 3 + 5 = 11
 *
 * Approach:
 * 1. Use a boolean array to track distinct characters.
 * 2. Check every character in the password.
 * 3. If it appears for the first time, add points based on its type.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int passwordStrength(String password) {
        boolean[] seen = new boolean[128];
        int strength = 0;

        for (char ch : password.toCharArray()) {

            // Add points only for distinct characters
            if (!seen[ch]) {
                seen[ch] = true;

                if (Character.isLowerCase(ch)) {
                    strength += 1;
                } else if (Character.isUpperCase(ch)) {
                    strength += 2;
                } else if (Character.isDigit(ch)) {
                    strength += 3;
                } else {
                    // Special characters: ! @ # $
                    strength += 5;
                }
            }
        }

        return strength;
    }
}
