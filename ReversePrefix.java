/*
Question:
Given a string s and an integer k,
reverse the first k characters of s
and return the resulting string.

Example:
Input: s = "abcd", k = 2
Output: "bacd"
*/

class Solution {
    public String reverseFirstK(String s, int k) {

        // Convert string to char array
        char[] arr = s.toCharArray();

        // Two pointers
        int left = 0;
        int right = k - 1;

        // Reverse first k characters
        while (left < right) {

            // Swap characters
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        // Convert back to string
        return new String(arr);
    }
}
