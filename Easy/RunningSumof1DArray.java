/*Question
Given an array nums.
Return the running sum of the array.
The running sum at index i is:
nums[0] + nums[1] + ... + nums[i]
Example
Input: nums = [1,2,3,4]

Output: [1,3,6,10]
  */
class RunningSumof1DArray
  {
    public int[] runningSum(int[] nums) {

        // Start from index 1 because the first element remains the same
        for (int i = 1; i < nums.length; i++) {

            // Add the previous running sum to the current element
            nums[i] = nums[i] + nums[i - 1];
        }

        // Return the modified array
        return nums;
    }
  }
