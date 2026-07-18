/**
 * 🧠 Problem:
 * Count how many strings in patterns are substrings of word
 *
 * 📥 Input:
 * patterns = ["a","abc","bc","d"], word = "abc"
 *
 * 📤 Output:
 * 3
 *
 * ⚡ Approach:
 * - For each pattern:
 *     → check if it exists in word using contains()
 * - Count matches
 *
 * ⏱ Time: O(n * m)
 * ⏱ Space: O(1)
 */

class Solution {
    public int numOfStrings(String[] patterns, String word) {

        int count = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }

        return count;
    }
}
