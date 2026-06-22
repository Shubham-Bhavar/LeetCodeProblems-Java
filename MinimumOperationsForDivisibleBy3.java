/*
Question:
In one operation, add or subtract 1 from any element.
Return the minimum operations needed to make all elements
of the array divisible by 3.
*/

class Solution {
    public int minimumOperations(int[] nums) {

        int operations = 0;

        // Check each number
        for (int num : nums) {

            int remainder = num % 3;

            // If remainder is 1 or 2,
            // only 1 operation is needed
            if (remainder != 0) {
                operations++;
            }
        }

        return operations;
    }
}
