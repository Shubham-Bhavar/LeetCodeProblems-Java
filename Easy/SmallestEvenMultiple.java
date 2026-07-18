// Question:
// Find smallest number divisible by both n and 2

class Solution {

    public int smallestEvenMultiple(int n) {

        // if n is even
        if (n % 2 == 0) {
            return n;
        }

        // if n is odd
        return n * 2;
    }
}
