/*
LeetCode: Minimum Cost to Reach Each Position

Problem:
For each position i, find the minimum cost to reach that position.

Approach:
1. At position i, we can pay cost[i] to swap with person i.
2. Once we reach a position using a cheaper previous cost,
   we can move further for free.
3. So, keep track of the minimum cost seen so far.
4. For every index, answer[i] = minimum cost from cost[0..i].

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] minCosts(int[] cost) {

        int n = cost.length;
        int[] answer = new int[n];

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            // Update minimum cost seen so far
            minCost = Math.min(minCost, cost[i]);

            // Minimum cost to reach position i
            answer[i] = minCost;
        }

        return answer;
    }
}
