/*
LeetCode - Maximum XOR After Operations

Approach:
The operation can turn any set bit (1) of a number into 0.

Therefore, for every bit position:
if at least one number contains that bit,
we can keep that bit as 1 in the final XOR.

So the maximum possible XOR is the
bitwise OR of all elements.

Example:
nums = [3, 2, 4, 6]

3 | 2 | 4 | 6 = 7

Answer = 7

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maximumXOR(int[] nums) 
    {
        int ans = 0;

        for(int num : nums)
        {
            ans = ans | num;
        }

        return ans;
    }
}
