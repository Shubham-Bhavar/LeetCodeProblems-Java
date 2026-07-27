/*
Approach:
1. Convert the string to lowercase so that 'a' and 'A' are treated as the same key.
2. Traverse the string from left to right.
3. Compare each character with the previous one.
4. If they are different, increment the key change count.
5. Return the total count.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int countKeyChanges(String s) {
        int changes = 0;

        // Convert the string to lowercase to ignore case differences
        s = s.toLowerCase();

        // Count key changes
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                changes++;
            }
        }

        return changes;
    }
}

