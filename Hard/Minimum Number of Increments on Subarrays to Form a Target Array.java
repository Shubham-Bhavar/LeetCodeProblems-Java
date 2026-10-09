/*
 * LeetCode 1526: Minimum Number of Increments on Subarrays
 * to Form a Target Array
 *
 * Problem:
 * Initially, an array contains only zeros.
 * In one operation, choose any subarray and increment
 * every element in that subarray by one.
 *
 * Return the minimum number of operations required
 * to form the target array.
 *
 * Example 1:
 * Input:  target = [1,2,3,2,1]
 * Output: 3
 *
 * Example 2:
 * Input:  target = [3,1,1,2]
 * Output: 4
 *
 * Example 3:
 * Input:  target = [3,1,5,4,2]
 * Output: 7
 *
 * Constraints:
 * 1 <= target.length <= 10^5
 * 1 <= target[i] <= 10^5
 *
 * Approach:
 * 1. The first element requires target[0] operations.
 * 2. For each next element, count only its increase
 *    compared with the previous element.
 * 3. If the current element is smaller or equal,
 *    no additional operations are needed.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minNumberOperations(int[] target) {

        int operations = target[0];

        for (int i = 1; i < target.length; i++) {

            if (target[i] > target[i - 1]) {
                operations += target[i] - target[i - 1];
            }
        }

        return operations;
    }
}
