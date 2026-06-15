/*Given an array of strings sentences, where each string is a sentence.

Return the maximum number of words present in a single sentence.*/
class Solution {
    public int mostWordsFound(String[] sentences) {

        // Store maximum word count
        int max = 0;

        // Traverse each sentence
        for (String sentence : sentences) {

            // Split sentence into words
            String[] words = sentence.split(" ");

            // Update maximum count
            max = Math.max(max, words.length);
        }

        return max;
    }
}
