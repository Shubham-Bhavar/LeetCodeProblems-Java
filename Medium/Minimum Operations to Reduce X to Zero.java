/*
    LeetCode 1658 - Minimum Operations to Reduce X to Zero

    Problem:
    --------
    Given an integer array nums and an integer x, in one operation
    remove the leftmost or rightmost element and subtract its value
    from x.

    Return the minimum number of operations needed to reduce x to
    exactly 0. If it is impossible, return -1.

    Example:
    nums = [1,1,4,2,3], x = 5
    Output = 2

    Approach:
    ---------
    Instead of removing elements from both ends, find the longest
    subarray that can be left behind.

    If total sum = S,
    then the remaining subarray must have sum:

        S - x

    So:
        minimum operations = nums.length - longest subarray length

    Since all numbers are positive, use sliding window.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/

class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        // If target is negative, impossible
        if (target < 0) {
            return -1;
        }

        // If target is 0, remove all elements
        if (target == 0) {
            return nums.length;
        }

        int left = 0;
        int sum = 0;
        int maxLength = -1;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > target) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}
