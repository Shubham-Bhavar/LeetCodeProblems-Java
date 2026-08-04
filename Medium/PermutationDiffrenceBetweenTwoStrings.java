/*
LeetCode 3146:
Permutation Difference between Two Strings
*/

import java.util.*;

public class Main {

    public static int findPermutationDifference(String s, String t) {
        int[] pos = new int[26];

        // Store index of each character in s
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'] = i;
        }

        int sum = 0;

        // Compare with t
        for (int i = 0; i < t.length(); i++) {
            int indexInS = pos[t.charAt(i) - 'a'];
            sum += Math.abs(indexInS - i);
        }

        return sum;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "bac";

        System.out.println(findPermutationDifference(s, t));
    }
}
