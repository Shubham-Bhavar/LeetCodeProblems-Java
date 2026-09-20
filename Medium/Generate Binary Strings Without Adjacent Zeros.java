/*
    LeetCode 3211 - Generate Binary Strings Without Adjacent Zeros

    Problem:
    --------
    Given a positive integer n, generate all binary strings of
    length n where no two zeros are adjacent.

    Example:
    Input:  n = 3
    Output: ["010", "011", "101", "110", "111"]

    Approach:
    ---------
    Use Backtracking.

    At every position:
    - We can always add '1'.
    - We can add '0' only if the previous character is not '0'.

    When the string reaches length n, add it to the result.

    Time Complexity:
    O(2^n)

    Space Complexity:
    O(n) excluding the result.
*/

import java.util.*;

class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();

        backtrack(n, new StringBuilder(), result);

        return result;
    }

    private void backtrack(
        int n,
        StringBuilder current,
        List<String> result
    ) {
        if (current.length() == n) {
            result.add(current.toString());
            return;
        }

        // Add 1 - always allowed
        current.append('1');
        backtrack(n, current, result);
        current.deleteCharAt(current.length() - 1);

        // Add 0 - allowed only if previous character is not 0
        if (current.length() == 0 || current.charAt(current.length() - 1) != '0') {
            current.append('0');
            backtrack(n, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
