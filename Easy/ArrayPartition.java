/*🔹 Problem
Given an integer array nums of size 2n, divide it into n pairs such that the sum of the minimum of each pair is maximized.*/
import java.util.Arrays;

public class ArrayPartition {

    public static int arrayPairSum(int[] nums) {
        // Step 1: Sort array
        Arrays.sort(nums);

        int sum = 0;

        // Step 2: Take elements at even indices
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
