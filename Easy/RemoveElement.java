// Problem: Remove Element
// Approach (Beginner Friendly):
// Use pointer k to store elements not equal to val
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int removeElement(int[] nums, int val) {

        int k = 0; // position to place next valid element

        for (int i = 0; i < nums.length; i++) {

            // if element is NOT equal to val
            if (nums[i] != val) {
                nums[k] = nums[i]; // place it at front
                k++;
            }
        }

        return k; // number of valid elements
    }
}
