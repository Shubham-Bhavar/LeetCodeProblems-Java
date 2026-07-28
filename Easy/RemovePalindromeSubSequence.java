// Problem (Simple):
// Given a string of 'a' and 'b',
// remove palindromic subsequences in minimum steps to make string empty.

import java.util.*;

class Solution {
    public static int removePalindromeSub(String s) {
        // check if whole string is palindrome
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return 2; // not palindrome → need 2 steps
            }
            i++;
            j--;
        }

        return 1; // already palindrome → 1 step
    }

    public static void main(String[] args) {
        String s = "abb";
        System.out.println("Minimum Steps: " + removePalindromeSub(s));
    }
}
