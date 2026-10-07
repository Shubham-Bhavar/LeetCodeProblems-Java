/*
 * LeetCode 398: Random Pick Index
 *
 * Problem:
 * Given an integer array nums with possible duplicates,
 * randomly return an index of a given target number.
 *
 * If the target appears at multiple indices, every valid index
 * must have an equal probability of being selected.
 *
 * Example:
 * Input:
 * nums = [1, 2, 3, 3, 3]
 *
 * pick(3) -> 2, 3, or 4 randomly
 * pick(1) -> 0
 *
 * Approach:
 * 1. Store all indices of each number in a HashMap.
 * 2. For pick(target), get the list of indices.
 * 3. Generate a random number from 0 to list.size() - 1.
 * 4. Return the selected index.
 *
 * Time Complexity:
 * Constructor -> O(n)
 * pick()      -> O(1)
 *
 * Space Complexity:
 * O(n)
 */

import java.util.*;

class Solution {

    private Map<Integer, List<Integer>> map;
    private Random random;

    public Solution(int[] nums) {

        map = new HashMap<>();
        random = new Random();

        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }

            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {

        List<Integer> indices = map.get(target);

        int randomIndex = random.nextInt(indices.size());

        return indices.get(randomIndex);
    }
}
