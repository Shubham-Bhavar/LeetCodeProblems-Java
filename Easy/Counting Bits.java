/*
* Problem: 338. Counting Bits
* Difficulty: Easy
* Approach: Dynamic Programming + Bit Manipulation
* Time Complexity: O(n)
* Space Complexity: O(n)
*/
class Solution {

    public int[] countBits(int n) {

        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
}
