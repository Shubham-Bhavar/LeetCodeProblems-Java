/*
LeetCode: Mean of Array After Removing Some Elements

Problem:
Remove the smallest 5% and largest 5% elements
from the array, then return the mean of the remaining elements.

Example:
Input:  [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
Output: 2.0
*/

import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {

        Arrays.sort(arr);

        int remove = arr.length / 20;
        int sum = 0;

        // Add elements after removing smallest 5%
        // and largest 5%
        for (int i = remove; i < arr.length - remove; i++) {
            sum += arr[i];
        }

        int count = arr.length - (2 * remove);

        return (double) sum / count;
    }
}
