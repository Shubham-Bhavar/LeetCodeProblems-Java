/*
Q: Create a new array such that:
   - First half = original array
   - Second half = reversed array
*/

class Solution {
    public int[] constructArray(int[] nums) {

        int n = nums.length;              // size of array
        int[] ans = new int[2 * n];       // why 2*n? → original + reverse

        for (int i = 0; i < n; i++) {

            ans[i] = nums[i];             // copy original

            // why (n - i - 1)?
            // to access elements from end → reverse order
            ans[i + n] = nums[n - i - 1];
        }

        return ans;                       // final result
    }
}
