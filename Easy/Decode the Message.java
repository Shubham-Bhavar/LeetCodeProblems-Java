/*
    LeetCode 2325 - Decode the Message

    Problem:
    --------
    Given a key and an encoded message, decode the message
    using a substitution table.

    The first appearance of each lowercase letter in the key
    determines its position in the substitution table.

    Example:
    key = "the quick brown fox jumps over the lazy dog"

    First unique letters:
    t h e q u i c k b r o w n f x j m p s v l a z y d g

    These letters are mapped to:
    a b c d e f g h i j k l m n o p q r s t u v w x y z

    Spaces remain unchanged.

    Approach:
    ---------
    1. Create a mapping array of size 26.
    2. Traverse the key.
    3. For every letter appearing for the first time,
       map it to the next alphabet letter.
    4. Traverse the message and replace each letter
       using the mapping.
    5. Keep spaces unchanged.

    Time Complexity:
    O(key.length + message.length)

    Space Complexity:
    O(26)
*/

class Solution {
    public String decodeMessage(String key, String message) {

        char[] map = new char[26];
        boolean[] used = new boolean[26];

        int index = 0;

        // Create substitution mapping from the key
        for (char ch : key.toCharArray()) {

            if (ch == ' ') {
                continue;
            }

            int letter = ch - 'a';

            if (!used[letter]) {
                used[letter] = true;
                map[letter] = (char) ('a' + index);
                index++;
            }
        }

        // Decode the message
        StringBuilder result = new StringBuilder();

        for (char ch : message.toCharArray()) {

            if (ch == ' ') {
                result.append(' ');
            } else {
                result.append(map[ch - 'a']);
            }
        }

        return result.toString();
    }
}
