    /*
     * Question:
     * Remove the minimum length prefix so that the
     * remaining array is strictly increasing.
     */
class Solution {

    public int minimumPrefixLength(int[] nums) {

        int n = nums.length;

        // Start from the end and find the longest
        // strictly increasing suffix.
        int i = n - 1;

        while (i > 0 && nums[i - 1] < nums[i]) {
            i--;
        }

        return i;
    }
}
