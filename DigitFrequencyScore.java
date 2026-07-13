/*
Question:
You are given an integer n.
The score of n is defined as:
sum of (digit * frequency of that digit).

Return the score.
*/

class Solution {
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10]; // store frequency of digits 0-9
        
        // count digit frequency
        while (n > 0) {
            int digit = n % 10;
            freq[digit]++;
            n /= 10;
        }
        
        int score = 0;
        
        // calculate score
        for (int d = 0; d <= 9; d++) {
            score += d * freq[d];
        }
        
        return score;
    }
}
