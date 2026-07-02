// Question:
// Count how many words contain only allowed characters

class Solution {

    public int countConsistentStrings(String allowed, String[] words) {

        int count = 0;

        // check each word
        for (String word : words) {

            boolean isValid = true;

            // check each character of word
            for (char ch : word.toCharArray()) {

                // if character not in allowed → invalid
                if (allowed.indexOf(ch) == -1) {
                    isValid = false;
                    break;
                }
            }

            // if valid, increase count
            if (isValid) {
                count++;
            }
        }

        return count;
    }
}
