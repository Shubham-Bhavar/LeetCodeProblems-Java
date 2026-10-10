/*
 * LeetCode 1630: Arithmetic Subarrays
 *
 * Problem:
 * For each query [l[i], r[i]], check whether the subarray
 * nums[l[i]...r[i]] can be rearranged into an arithmetic
 * sequence.
 *
 * An arithmetic sequence has the same difference between
 * every pair of consecutive elements.
 *
 * Example 1:
 * Input:
 * nums = [4,6,5,9,3,7]
 * l = [0,0,2]
 * r = [2,3,5]
 * Output: [true,false,true]
 *
 * Example 2:
 * Input:
 * nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10]
 * l = [0,1,6,4,8,7]
 * r = [4,4,9,7,9,10]
 * Output: [false,true,false,false,true,true]
 *
 * Constraints:
 * 2 <= nums.length <= 500
 * 1 <= l.length <= 500
 * -10^5 <= nums[i] <= 10^5
 *
 * Approach:
 * 1. Extract each queried subarray.
 * 2. Sort it in ascending order.
 * 3. Calculate the difference between the first two elements.
 * 4. Check whether all consecutive differences are equal.
 *
 * Time Complexity: O(m * k log k)
 * Space Complexity: O(k)
 * m = number of queries, k = maximum query length.
 */

import java.util.*;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(
            int[] nums, int[] l, int[] r) {

        List<Boolean> answer = new ArrayList<>();

        for (int q = 0; q < l.length; q++) {

            // Extract the current subarray
            int[] subarray = Arrays.copyOfRange(
                    nums, l[q], r[q] + 1
            );

            // Sort to check possible rearrangement
            Arrays.sort(subarray);

            int difference = subarray[1] - subarray[0];
            boolean isArithmetic = true;

            // Check consecutive differences
            for (int i = 2; i < subarray.length; i++) {
                if (subarray[i] - subarray[i - 1] != difference) {
                    isArithmetic = false;
                    break;
                }
            }

            answer.add(isArithmetic);
        }

        return answer;
    }
}
