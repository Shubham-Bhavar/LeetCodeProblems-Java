```java
    /*
        LeetCode 78 - Subsets

        Problem:
        Given an integer array nums containing unique elements,
        return all possible subsets (the power set).

        Example:
        Input: nums = [1,2,3]

        Output:
        [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

        Approach:
        Use Backtracking.

        For every element:
        1. Choose the element.
        2. Explore further.
        3. Undo the choice.

        We add the current list to result at EVERY step
        because every partial list is a valid subset.

        Time Complexity:
        O(n * 2^n)

        Space Complexity:
        O(n) for recursion and current list
    */
import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int[] nums,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {

        // Every current list is a valid subset
        result.add(new ArrayList<>(current));

        // Try each remaining element
        for (int i = index; i < nums.length; i++) {

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, current, result);

            // Undo
            current.remove(current.size() - 1);
        }
    }
}
```
