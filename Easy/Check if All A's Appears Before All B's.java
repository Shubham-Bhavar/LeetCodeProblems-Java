/*
Problem:
Check whether all occurrences of 'a' appear before
all occurrences of 'b' in the given string.

Approach:
1. Find the first occurrence of 'b'.
2. Find the last occurrence of 'a'.
3. If 'b' does not exist OR the last 'a' is before
   the first 'b', return true.
4. Otherwise, return false.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean checkString(String s) {

        // Find the first occurrence of 'b'
        int firstB = s.indexOf('b');

        // Find the last occurrence of 'a'
        int lastA = s.lastIndexOf('a');

        // Check whether all 'a' appear before 'b'
        return firstB == -1 || lastA < firstB;
    }
}