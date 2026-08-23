    /*
     * Question:
     * Pair all elements of an even-length array such that
     * the maximum pair sum is minimized.
     *
     * Approach:
     * Sort the array and pair the smallest element
     * with the largest element.
     */
import java.util.Arrays;

class Solution {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int maxPairSum = 0;

        while (left < right) {
            int pairSum = nums[left] + nums[right];

            maxPairSum = Math.max(maxPairSum, pairSum);

            left++;
            right--;
        }

        return maxPairSum;
    }
}
