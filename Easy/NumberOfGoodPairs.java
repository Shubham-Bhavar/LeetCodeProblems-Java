/*Given an array nums, count the number of good pairs.

A pair (i, j) is good if:

nums[i] == nums[j]

and

i < j*/
class Solution {
    public int numIdenticalPairs(int[] nums) {

        // Store number of good pairs
        int count = 0;

        // Compare each element with remaining elements
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                // Found a good pair
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
