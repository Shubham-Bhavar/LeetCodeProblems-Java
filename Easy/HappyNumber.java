// Problem: Happy Number
// Approach:
// 1. Find sum of squares of digits
// 2. Repeat
// 3. If becomes 1 → true
// 4. If repeats → false (cycle)

import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {

            seen.add(n);
            n = getSquareSum(n);
        }

        return n == 1;
    }

    // helper to calculate square sum
    private int getSquareSum(int n) {

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}
