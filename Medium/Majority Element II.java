
/*
 * LeetCode 229: Majority Element II
 *
 * Problem:
 * Given an integer array nums, find all elements that
 * appear more than floor(n / 3) times.
 *
 * Approach: HashMap
 *
 * Explanation:
 * 1. Create a HashMap to store each number and its frequency.
 * 2. Traverse the array and update the frequency of each number.
 * 3. Traverse the HashMap and check which numbers appear
 *    more than nums.length / 3 times.
 * 4. Add those numbers to the result list.
 * 5. Return the result list.
 *
 * Note:
 * There can be at most two elements that appear more
 * than n / 3 times.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            if (map.get(num) > nums.length / 3) {
                ans.add(num);
            }
        }

        return ans;
    }
}
