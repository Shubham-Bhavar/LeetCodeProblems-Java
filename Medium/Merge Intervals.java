    /*
        LeetCode 56 - Merge Intervals

        Problem:
        ----------
        Given an array of intervals [start, end],
        merge all overlapping intervals.

        Example:
        Input:
        [[1,3],[2,6],[8,10],[15,18]]

        Output:
        [[1,6],[8,10],[15,18]]


        Approach:
        ----------
        1. Sort intervals by their starting point.
        2. Take the first interval as the current interval.
        3. Check the next interval:
           
           If:
               nextStart <= currentEnd

           Then the intervals overlap.

           Merge them by updating:
               currentEnd = max(currentEnd, nextEnd)

        4. If they don't overlap:
           Add the current interval to the result
           and make the next interval the current interval.

        5. Add the last interval.


        Example:
        --------
        [[1,3], [2,6], [8,10]]

        Current = [1,3]

        [2,6]:
        2 <= 3 → overlap
        Merge → [1,6]

        [8,10]:
        8 > 6 → no overlap
        Add [1,6]

        Start new interval → [8,10]


        Important Condition:
        --------------------
        nextStart <= currentEnd

        We use <= because intervals touching at an endpoint
        are also considered overlapping.

        Example:
        [1,4] and [4,5]

        4 <= 4 → overlap
        Result = [1,5]


        Time Complexity:
        ----------------
        Sorting: O(n log n)
        Traversing: O(n)

        Overall: O(n log n)


        Space Complexity:
        -----------------
        O(n) for the result.
    */
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals by starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Store the merged intervals
        List<int[]> result = new ArrayList<>();

        // Start with the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Check all remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            // If intervals overlap
            if (nextStart <= end) {

                // Extend the current interval
                end = Math.max(end, nextEnd);
            }
            else {

                // No overlap, so save current interval
                result.add(new int[]{start, end});

                // Start a new interval
                start = nextStart;
                end = nextEnd;
            }
        }

        // Add the final interval
        result.add(new int[]{start, end});

        // Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }
}
