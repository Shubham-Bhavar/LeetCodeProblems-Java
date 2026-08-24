    /*
     * Question:
     * Divide the array into 3 non-empty contiguous subarrays
     * and return the minimum sum of their costs.
     *
     * Cost of a subarray = its first element.
     *
     * The first subarray always starts at nums[0],
     * so nums[0] is always included in the answer.
     * Find the two smallest values from nums[1...n-1].
     */
class Solution {

    public int minimumCost(int[] nums) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < firstMin) {
                secondMin = firstMin;
                firstMin = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }

        return nums[0] + firstMin + secondMin;
    }
}
