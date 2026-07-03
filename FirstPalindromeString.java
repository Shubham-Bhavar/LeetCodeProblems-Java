// Question:
// Find first palindromic string in array (without separate function)

class Solution {

    public String firstPalindrome(String[] words) {

        // check each word
        for (String word : words) {

            int left = 0;
            int right = word.length() - 1;

            boolean isPal = true;

            // check palindrome directly here
            while (left < right) {

                if (word.charAt(left) != word.charAt(right)) {
                    isPal = false;
                    break;
                }

                left++;
                right--;
            }

            // if palindrome found
            if (isPal) {
                return word;
            }
        }

        return "";
    }
}
