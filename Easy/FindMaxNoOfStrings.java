/*
Question:
You are given a 0-indexed array words consisting of distinct strings.

The string words[i] can be paired with the string words[j] if:
1) words[i] is equal to the reversed string of words[j]
2) 0 <= i < j < words.length

Return the maximum number of pairs that can be formed.
Each string can be used at most once.

Example:
Input: ["cd","ac","dc","ca","zz"]
Output: 2
*/

import java.util.*;

public class MaxPairsReverseStrings {

    public static int maximumNumberOfPairs(String[] words) {
        Set<String> set = new HashSet<>();
        int count = 0;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (set.contains(reversed)) {
                count++;
                set.remove(reversed);
            } else {
                set.add(word);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words1 = {"cd","ac","dc","ca","zz"};
        System.out.println(maximumNumberOfPairs(words1)); // 2
    }
}
