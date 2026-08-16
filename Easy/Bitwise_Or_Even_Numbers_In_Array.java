/*
Question:
Return the bitwise OR of all even numbers in the array.

If there are no even numbers, return 0.

Example:
nums = [1, 2, 3, 4, 5, 6]

Even numbers = 2, 4, 6
2 | 4 | 6 = 6

Output: 6
*/

class Solution {
    public int evenNumberBitwiseORs(int[] nums) {

        int result = 0;

        for (int num : nums) {

            // Check if the number is even
            if (num % 2 == 0) {
                result = result | num;
            }
        }

        return result;
    }
}
