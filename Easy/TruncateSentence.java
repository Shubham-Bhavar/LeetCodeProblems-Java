// Question:
// Return first k words from a sentence

class Solution {

    public String truncateSentence(String s, int k) {

        String[] words = s.split(" "); // split sentence into words

        String result = "";

        // take first k words
        for (int i = 0; i < k; i++) {

            result += words[i];

            // add space except last word
            if (i != k - 1) {
                result += " ";
            }
        }

        return result;
    }
}
