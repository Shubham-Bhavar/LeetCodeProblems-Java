
/*
 * Problem: 784. Letter Case Permutation
 * Difficulty: Medium
 * Language: Java
 *
 * Approach:
 * 1. Use Backtracking to generate all possible strings.
 * 2. For each character, check whether it is a letter.
 * 3. Try both lowercase and uppercase.
 * 4. Keep digits unchanged.
 *
 * Time Complexity: O(n * 2^L)
 * Space Complexity: O(n * 2^L)
 * L = number of letters in the string.
 */

import java.util.*;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result);
        return result;
    }

    private void backtrack(char[] chars, int index,
                           List<String> result) {

        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        if (Character.isLetter(chars[index])) {

            chars[index] = Character.toLowerCase(chars[index]);
            backtrack(chars, index + 1, result);

            chars[index] = Character.toUpperCase(chars[index]);
            backtrack(chars, index + 1, result);

        } else {
            backtrack(chars, index + 1, result);
        }
    }
}
