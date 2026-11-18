
/*
 * LeetCode 2914: Minimum Number of Changes to Make Binary String Beautiful
 *
 * Problem:
 * Make the binary string beautiful using minimum changes.
 * Every substring of length 2 must contain equal characters.
 *
 * Approach:
 * Greedy Approach.
 *
 * Step-by-step:
 * 1. Traverse the string two characters at a time.
 * 2. Compare each pair of characters.
 * 3. If both characters are different,
 *    one character must be changed.
 * 4. Increase the changes count.
 * 5. Return the total changes.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minChanges(String s) {

        int changes = 0;

        for (int i = 0; i < s.length(); i += 2) {

            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }

        return changes;
    }
}
