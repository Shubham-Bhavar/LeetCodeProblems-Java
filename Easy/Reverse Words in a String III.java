/*
LeetCode: Reverse Words in a String III

Problem:
Reverse the characters of each word in the string,
while keeping the order of words and spaces unchanged.

Example:
Input  : "Let's take LeetCode contest"
Output : "s'teL ekat edoCteeL tsetnoc"

Approach:
1. Convert the string into a character array.
2. Traverse the array.
3. Find the start and end of each word.
4. Reverse the characters of that word.
5. Spaces remain unchanged.

Time Complexity:
O(n)

Space Complexity:
O(n)
*/

class Solution {
    public String reverseWords(String s) {

        char[] arr = s.toCharArray();
        int start = 0;

        for (int i = 0; i <= arr.length; i++) {

            if (i == arr.length || arr[i] == ' ') {

                int left = start;
                int right = i - 1;

                while (left < right) {

                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;

                    left++;
                    right--;
                }

                start = i + 1;
            }
        }

        return new String(arr);
    }
}
