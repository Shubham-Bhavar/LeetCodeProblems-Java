    /*
    ❓ Goal: Total subarray sum for each index
    ❓ Start: max(0, i - nums[i])
    ❓ Process: sum from start to i
    ❓ Return: total
    */
class Solution {

    public int subarraySum(int[] nums) {
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);

            for (int j = start; j <= i; j++) {
                total += nums[j];
            }
        }

        return total;
    }
}
