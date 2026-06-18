/*
2427. Number of Common Factors

Given two integers a and b, return the number of common factors.

Example:
a = 12, b = 6 → output = 4
*/

public class Solution {
    public int commonFactors(int a, int b) {

        // store count of common factors
        int count = 0;

        // find minimum of a and b
        int min = Math.min(a, b);

        // check all numbers from 1 to min
        for (int i = 1; i <= min; i++) {

            // if i divides both a and b, it is a common factor
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }

        // return total count
        return count;
    }
}
