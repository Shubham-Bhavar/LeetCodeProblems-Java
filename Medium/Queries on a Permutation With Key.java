/*
LeetCode 1409 - Queries on a Permutation With Key

Problem:
Given queries and an integer m, initially the permutation is:
P = [1, 2, 3, ..., m]

For each query:
1. Find the position of queries[i] in P.
2. Store that position in the answer.
3. Move the queried value to the beginning of P.

Example:
Input:
queries = [3,1,2,1]
m = 5

Output:
[2,1,2,1]

Approach:
- Use ArrayList to store the current permutation.
- indexOf() finds the position of the queried value.
- remove() removes it from its current position.
- add(0, value) moves it to the beginning.

Time Complexity: O(n * m)
Space Complexity: O(m)
*/

import java.util.*;

class Solution {
    public int[] processQueries(int[] queries, int m) 
    {
        List<Integer> list = new ArrayList<>();

        // Create permutation [1, 2, 3, ..., m]
        for(int i = 1; i <= m; i++)
        {
            list.add(i);
        }

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++)
        {
            // Find position of query
            int index = list.indexOf(queries[i]);

            // Store position
            ans[i] = index;

            // Move queried value to beginning
            int value = list.remove(index);
            list.add(0, value);
        }

        return ans;
    }
}
