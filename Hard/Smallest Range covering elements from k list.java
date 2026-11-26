
/*
 * LeetCode 632: Smallest Range Covering Elements from K Lists
 *
 * Problem:
 * Find the smallest range that includes at least one
 * number from each of the k sorted lists.
 *
 * Approach: Min Heap
 *
 * 1. Add the first element of every list to the min heap.
 * 2. Track the current maximum element.
 * 3. Remove the minimum element from the heap.
 * 4. Update the smallest range if the current range is better.
 * 5. Add the next element from the list of the removed element.
 * 6. Stop when any list has no more elements.
 *
 * Time Complexity: O(N log k)
 * Space Complexity: O(k)
 *
 * N = Total number of elements
 * k = Number of lists
 */

import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);

            pq.offer(new int[]{value, i, 0});
            max = Math.max(max, value);
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        while (pq.size() == nums.size()) {
            int[] curr = pq.poll();

            int min = curr[0];

            if ((long) max - min < (long) end - start) {
                start = min;
                end = max;
            }

            int listIndex = curr[1];
            int elementIndex = curr[2] + 1;

            if (elementIndex == nums.get(listIndex).size()) {
                break;
            }

            int next = nums.get(listIndex).get(elementIndex);

            pq.offer(new int[]{next, listIndex, elementIndex});
            max = Math.max(max, next);
        }

        return new int[]{start, end};
    }
}
