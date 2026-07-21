// Problem: Search Insert Position
// Approach: Binary Search
// If target found → return index
// If not → return position where it should be inserted

class Solution {
    public int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid; // found
            }
            else if (nums[mid] < target) {
                low = mid + 1; // go right
            }
            else {
                high = mid - 1; // go left
            }
        }

        // target not found → correct insert position
        return low;
    }
}
