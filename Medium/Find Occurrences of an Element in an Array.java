/*
Question:
For each query, find the index of the kth occurrence of x in nums.
If the kth occurrence does not exist, return -1.

Approach:
1. Store all indices where nums[i] == x.
2. For each query k, check if the kth occurrence exists.
3. Return its index or -1.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] occurrencesOfElement(
            int[] nums,
            int[] queries,
            int x
    ) {

        // Store indices of all occurrences of x
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                indices.add(i);
            }
        }

        int[] answer = new int[queries.length];

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int occurrence = queries[i];

            if (occurrence <= indices.size()) {
                answer[i] = indices.get(occurrence - 1);
            } else {
                answer[i] = -1;
            }
        }

        return answer;
    }
}
