/*
LeetCode: Construct the Minimum Bitwise Array I

Problem:
For every nums[i], find the minimum value x such that:

x | (x + 1) == nums[i]

If no such x exists, return -1.

Approach:
1. For every number nums[i], try all possible values of x.
2. Check whether:
      x | (x + 1) == nums[i]
3. The first valid x is the minimum answer.
4. If no value is found, store -1.

Example:
nums = [2, 3, 5, 7]

For 2:
No x satisfies x | (x + 1) = 2
Answer = -1

For 3:
1 | 2 = 3
Answer = 1

For 5:
4 | 5 = 5
Answer = 4

For 7:
3 | 4 = 7
Answer = 3

Output:
[-1, 1, 4, 3]

Time Complexity:
O(n * max(nums))

Space Complexity:
O(n)
*/

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {

        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int num = nums.get(i);
            ans[i] = -1;

            for (int x = 0; x < num; x++) {

                if ((x | (x + 1)) == num) {
                    ans[i] = x;
                    break;
                }
            }
        }

        return ans;
    }
}
