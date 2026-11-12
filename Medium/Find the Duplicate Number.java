
/*
 * LeetCode 287: Find the Duplicate Number
 *
 * Problem:
 * Given an array nums containing n + 1 integers,
 * where each integer is in the range [1, n],
 * find the number that appears more than once.
 *
 * Approach: Floyd's Cycle Detection Algorithm
 *
 * Explanation:
 * 1. Use two pointers: slow and fast.
 * 2. Move slow one step and fast two steps.
 * 3. Continue until both pointers meet.
 * 4. Reset slow to index 0.
 * 5. Move both pointers one step at a time.
 * 6. Their next meeting point is the duplicate number.
 *
 * Note:
 * - The original array is not modified.
 * - No HashMap or extra array is used.
 * - At least one duplicate must exist because
 *   n + 1 elements are placed in only n possible values.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Detect the cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find the starting point of the cycle
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
