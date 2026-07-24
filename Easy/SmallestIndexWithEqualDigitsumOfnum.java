/*Given an integer array nums, return the smallest index i such that the sum of digits of nums[i] equals i.

If no such index exists, return -1.*/
public int smallestIndex(int[] nums) 
{
    for (int i = 0; i < nums.length; i++) {
        int num = nums[i], sum = 0;

        // Calculate digit sum
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        // Check condition
        if (sum == i) {
            return i;
        }
    }
    return -1;
}
