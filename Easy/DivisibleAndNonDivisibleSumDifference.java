/*
Question:
Find the sum of numbers from 1 to n that are NOT divisible by m (num1)
and the sum of numbers that ARE divisible by m (num2).
Return num1 - num2.
*/

class Solution {
    public int differenceOfSums(int n, int m) {

        int num1 = 0; // Sum of non-divisible numbers
        int num2 = 0; // Sum of divisible numbers

        // Check every number from 1 to n
        for (int i = 1; i <= n; i++) {

            if (i % m == 0) {
                num2 += i; // Add divisible number
            } else {
                num1 += i; // Add non-divisible number
            }
        }

        // Return the required difference
        return num1 - num2;
    }
}
