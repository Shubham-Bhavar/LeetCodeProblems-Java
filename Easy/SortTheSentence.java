/*
Approach:
1. Split the sentence into words.
2. The last character of each word represents its position.
3. Remove the digit and place the word at the correct index.
4. Join all words with spaces.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String sortSentence(String s) {

        // Split the sentence into individual words
        String[] words = s.split(" ");

        // Array to store words in their correct positions
        String[] result = new String[words.length];

        // Place each word at its original position
        for (String word : words) {
            int index = word.charAt(word.length() - 1) - '1';
            result[index] = word.substring(0, word.length() - 1);
        }

        // Join all words to form the original sentence
        return String.join(" ", result);
    }
}

