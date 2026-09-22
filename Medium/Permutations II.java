/*
    LeetCode 47 - Permutations II

    Problem:
    --------
    Given an array of numbers that may contain duplicates,
    return all possible unique permutations in any order.

    Example 1:
    Input:
    nums = [1,1,2]

    Output:
    [[1,1,2],
     [1,2,1],
     [2,1,1]]

    Example 2:
    Input:
    nums = [1,2,3]

    Output:
    [[1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]]

    Constraints:
    ------------
    1 <= nums.length <= 8
    -10 <= nums[i] <= 10

    Approach:
    ---------
    1. Sort the array so duplicate values are together.
    2. Use backtracking to generate permutations.
    3. Use a boolean array to track used elements.
    4. Skip duplicate values when the previous identical value
       has not been used at the current level.

    Pattern:
    --------
    Choose -> Explore -> Undo

    Time Complexity:
    ----------------
    O(n * n!)

    Space Complexity:
    -----------------
    O(n), excluding the output.
*/
import java.util.*;

class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Sort to handle duplicates
        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int[] nums,
            boolean[] used,
            List<Integer> current,
            List<List<Integer>> result) {

        // Complete permutation
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip already used element
            if (used[i]) {
                continue;
            }

            // Skip duplicate permutation
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Explore
            backtrack(nums, used, current, result);

            // Undo
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
