/*
Question:
Find the product of digits
and sum of digits of a number.

Return:
product - sum
*/

class Solution {

    public int subtractProductAndSum(int n) {

        // Product starts with 1
        int product = 1;

        // Sum starts with 0
        int sum = 0;

        // Process each digit
        while (n > 0) {

            // Get last digit
            int digit = n % 10;

            // Add to sum
            sum += digit;

            // Multiply to product
            product *= digit;

            // Remove last digit
            n = n / 10;
        }

        // Return answer
        return product - sum;
    }
}
