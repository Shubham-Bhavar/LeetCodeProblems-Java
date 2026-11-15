
/*
 * LeetCode 219: Contains Duplicate II
 *
 * Problem:
 * Given an integer array nums and an integer k,
 * check whether two distinct indices i and j exist
 * such that:
 *
 * nums[i] == nums[j]
 * abs(i - j) <= k
 *
 * Approach: HashMap (Last Seen Index)
 *
 * Explanation:
 * 1. Create a HashMap to store each number and its
 *    most recent index.
 *
 * 2. Traverse the array using a for loop.
 *
 * 3. Check whether the current number exists in
 *    the HashMap.
 *
 * 4. If it exists, calculate the difference between
 *    the current index and its previous index.
 *
 * 5. If the difference is <= k, return true.
 *
 * 6. Otherwise, update the number's latest index.
 *
 * 7. If no valid pair is found, return false.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {

                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }

            map.put(nums[i], i);
        }

        return false;
    }
}
