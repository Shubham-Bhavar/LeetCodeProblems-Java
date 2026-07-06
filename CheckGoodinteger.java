// Problem:
// Given an integer n, compute:
// digitSum = sum of digits
// squareSum = sum of squares of digits
// Return true if (squareSum - digitSum) >= 50, else false.

class Solution {
    public boolean isGood(int n) {
        
        int digitSum = 0;    // Sum of digits
        int squareSum = 0;   // Sum of squares of digits
        
        // Extract digits one by one
        while (n > 0) {
            int digit = n % 10;   // Get last digit
            
            digitSum += digit;           // Add to digit sum
            squareSum += digit * digit;  // Add square to square sum
            
            n = n / 10;   // Remove last digit
        }
        
        // Check condition
        return (squareSum - digitSum) >= 50;
    }
}
