// Problem: Rank Transform of an Array
// Level: Easy
// Approach (Beginner Friendly):
// 1. Copy array and sort it
// 2. Assign rank to each unique element
// 3. Replace original values using map
// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {

        // Step 1: copy original array
        int[] temp = arr.clone();

        // Step 2: sort the copied array
        Arrays.sort(temp);

        // Step 3: create map for value → rank
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int num : temp) {
            // only assign rank if not already assigned
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }

        // Step 4: replace original array values with rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
