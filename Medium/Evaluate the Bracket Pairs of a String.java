/*
    LeetCode 1807 - Evaluate the Bracket Pairs of a String

    Problem:
    --------
    Given a string s containing bracket pairs and a knowledge array
    containing key-value pairs, replace every "(key)" with its value.

    If the key is not present in knowledge, replace "(key)" with "?".

    Example 1:
    Input:
    s = "(name)is(age)yearsold"
    knowledge = [["name","bob"],["age","two"]]

    Output:
    "bobistwoyearsold"

    Example 2:
    Input:
    s = "hi(name)"
    knowledge = [["a","b"]]

    Output:
    "hi?"

    Example 3:
    Input:
    s = "(a)(a)(a)aaa"
    knowledge = [["a","yes"]]

    Output:
    "yesyesyesaaa"

    Approach:
    ---------
    1. Store all key-value pairs in a HashMap.
    2. Traverse the string character by character.
    3. If the character is not '(', add it directly.
    4. When '(' is found:
       - Find the matching ')'.
       - Extract the key.
       - Get its value from the HashMap.
       - If the key does not exist, use "?".
    5. Continue after ')'.

    Time Complexity:
    O(n + k)

    n = length of string
    k = number of knowledge entries

    Space Complexity:
    O(k + n)

    HashMap stores k key-value pairs.
    StringBuilder stores the resulting string.
*/

import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        // Store key-value pairs
        Map<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            // Normal character
            if (s.charAt(i) != '(') {
                result.append(s.charAt(i));
                i++;
            }

            // Bracket pair
            else {
                int j = i + 1;

                // Find closing bracket
                while (s.charAt(j) != ')') {
                    j++;
                }

                // Extract key
                String key = s.substring(i + 1, j);

                // Get value or ?
                result.append(map.getOrDefault(key, "?"));

                // Move after ')'
                i = j + 1;
            }
        }

        return result.toString();
    }
}
