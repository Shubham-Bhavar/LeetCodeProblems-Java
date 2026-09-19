    /*
        LeetCode 17 - Letter Combinations of a Phone Number

        Problem:
        ----------
        Given a string containing digits from 2 to 9,
        return all possible letter combinations.

        Phone mapping:

        2 → abc
        3 → def
        4 → ghi
        5 → jkl
        6 → mno
        7 → pqrs
        8 → tuv
        9 → wxyz


        Example:
        Input:
            digits = "23"

        Output:
            ["ad","ae","af",
             "bd","be","bf",
             "cd","ce","cf"]


        Approach:
        ----------
        We use BACKTRACKING.

        For each digit:
            1. Get its letters.
            2. Choose one letter.
            3. Move to the next digit.
            4. Remove the chosen letter and try the next one.


        Example for "23":

                    ""
                 /  |  \
                a   b   c
              / | \ /|\ /|\
             ad ae af bd....


        Backtracking Pattern:

            Choose
              ↓
            Explore
              ↓
            Undo


        Base Case:
        -----------
        When current.length() == digits.length(),
        we have created one complete combination.

        Add it to the result.


        Time Complexity:
        ----------------
        O(4^n * n)

        At most 4 choices exist for each digit,
        and creating each string takes O(n).


        Space Complexity:
        -----------------
        O(n)

        For the recursion/current combination.

        The result itself requires O(4^n * n) space.
    */
import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        // Safety check for empty input
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Phone keypad mapping
        String[] phone = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(
            digits,
            0,
            new StringBuilder(),
            result,
            phone
        );

        return result;
    }

    private void backtrack(
            String digits,
            int index,
            StringBuilder current,
            List<String> result,
            String[] phone) {

        // Complete combination created
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for current digit
        String letters = phone[digits.charAt(index) - '0'];

        // Try every possible letter
        for (char letter : letters.toCharArray()) {

            // Choose
            current.append(letter);

            // Explore next digit
            backtrack(
                digits,
                index + 1,
                current,
                result,
                phone
            );

            // Undo
            current.deleteCharAt(current.length() - 1);
        }
    }
}
