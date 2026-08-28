/*
LeetCode: Score of a Prefix

Problem:
For each index i, find the score of the prefix nums[0..i].

For every element nums[i]:

    conver[i] = nums[i] + maximum value from nums[0] to nums[i]

The score is the sum of all values in the conversion array.

Return an array ans where:
ans[i] = score of the prefix nums[0..i].

Example:
Input: nums = [2, 3, 7, 5, 10]

Step-by-step:

i = 0:
Prefix Maximum = 2
conver[0] = 2 + 2 = 4
Score = 4

i = 1:
Prefix Maximum = 3
conver[1] = 3 + 3 = 6
Score = 4 + 6 = 10

i = 2:
Prefix Maximum = 7
conver[2] = 7 + 7 = 14
Score = 10 + 14 = 24

i = 3:
Prefix Maximum = 7
conver[3] = 5 + 7 = 12
Score = 24 + 12 = 36

i = 4:
Prefix Maximum = 10
conver[4] = 10 + 10 = 20
Score = 36 + 20 = 56

Output: [4, 10, 24, 36, 56]

Approach:
1. Keep track of the maximum value seen so far.
2. For each number, calculate:
   conversion value = current number + current maximum.
3. Add the conversion value to a running score.
4. Store the running score in the answer array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public long[] findPrefixScore(int[] nums) {

        int n = nums.length;
        long[] ans = new long[n];

        int max = 0;
        long score = 0;

        for (int i = 0; i < n; i++) {

            // Update maximum value seen so far
            max = Math.max(max, nums[i]);

            // Add current conversion value to the score
            score += (long) nums[i] + max;

            // Store prefix score
            ans[i] = score;
        }

        return ans;
    }
}
