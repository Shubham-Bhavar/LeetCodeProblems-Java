/*
 * LeetCode 1282: Group the People Given the Group Size They Belong To
 *
 * Problem:
 * There are n people labeled from 0 to n - 1.
 *
 * groupSizes[i] tells us the size of the group that person i
 * must belong to.
 *
 * We need to divide all people into groups such that:
 * 1. Every person appears exactly once.
 * 2. Every group has the required size.
 *
 * Example 1:
 * Input:
 * groupSizes = [3,3,3,3,3,1,3]
 *
 * Output:
 * [[5],[0,1,2],[3,4,6]]
 *
 * Example 2:
 * Input:
 * groupSizes = [2,1,3,3,3,2]
 *
 * Output:
 * [[1],[0,5],[2,3,4]]
 *
 * Approach:
 * - Use a HashMap to store people according to their group size.
 * - The key is the required group size.
 * - The value is the list of people waiting for that group.
 * - When the list reaches the required size, add it to the answer.
 * - Then create a new empty list for the same group size.
 *
 * Example:
 * groupSizes = [3,3,3]
 *
 * Size 3 -> [0]
 * Size 3 -> [0,1]
 * Size 3 -> [0,1,2] -> Complete group
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> result = new ArrayList<>();

        // Stores people according to their required group size
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int person = 0; person < groupSizes.length; person++) {

            int size = groupSizes[person];

            // Create a new list if this size is not present
            if (!map.containsKey(size)) {
                map.put(size, new ArrayList<>());
            }

            // Add the person to their group
            map.get(size).add(person);

            // If group is complete, add it to result
            if (map.get(size).size() == size) {

                result.add(map.get(size));

                // Start a new group for the same size
                map.put(size, new ArrayList<>());
            }
        }

        return result;
    }
}
