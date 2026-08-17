/*
Question:
Given an integer n, reverse its digits to get r.
Return the sum of all prime numbers between min(n, r)
and max(n, r), inclusive.

Example:
Input: n = 13
Output: 132

Explanation:
Reverse of 13 = 31
Range = [13, 31]
Primes = 13, 17, 19, 23, 29, 31
Sum = 132
*/

class Solution {
    public int reversePrimeSum(int n) {

        // Reverse the digits of n
        int r = 0;
        int temp = n;

        while (temp > 0) {
            r = r * 10 + temp % 10;
            temp /= 10;
        }

        // Find the range
        int start = Math.min(n, r);
        int end = Math.max(n, r);

        int sum = 0;

        // Add all prime numbers in the range
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }

        return sum;
    }

    // Checks whether a number is prime
    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
