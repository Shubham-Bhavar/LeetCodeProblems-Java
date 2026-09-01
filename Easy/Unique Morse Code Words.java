/*
===========================================================
LeetCode 804 - Unique Morse Code Words
===========================================================

Problem:
Convert every word into its Morse code transformation
and return the number of unique transformations.

Morse code mapping:
a -> .-
b -> -...
c -> -.-.
...
z -> --..

Example:
words = ["gin", "zen", "gig", "msg"]

gin -> --...-.
zen -> --...-.
gig -> --...--.
msg -> --...--.

Unique transformations = 2

Approach:
1. Store Morse codes of 26 letters in an array.
2. Convert each word into Morse code.
3. Store each transformation in a HashSet.
4. Return HashSet size.

Time Complexity: O(N * L)
Space Complexity: O(N * L)

===========================================================
*/

class Solution {
    public int uniqueMorseRepresentations(String[] words) {

        String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
        };

        HashSet<String> set = new HashSet<>();

        for (String word : words) {

            StringBuilder sb = new StringBuilder();

            for (char ch : word.toCharArray()) {
                sb.append(morse[ch - 'a']);
            }

            set.add(sb.toString());
        }

        return set.size();
    }
}
