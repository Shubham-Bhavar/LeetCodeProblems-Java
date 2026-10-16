/*
LeetCode 2916: Subarrays Distinct Element Sum of Squares II
Difficulty: Hard

Approach:
1. Sweep the right end i of the subarray. Let f[l] = number of distinct
   values in nums[l..i].
2. When nums[i] arrives, f[l] increases by 1 exactly for the left ends l
   after the previous occurrence of nums[i] (positions prev+1 .. i).
   lastSeen stores that previous position + 1 (0 if never seen).
3. A segment tree with lazy propagation supports "add 1 to a range" while
   maintaining both sum(f) and sum(f^2) per node, using
   (x + v)^2 = x^2 + 2*v*x + v^2.
4. After each step, sum(f^2) over all left ends is added to the answer.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[] sum;     // sum of f[l] over the node's range
    private long[] square;  // sum of f[l]^2 over the node's range
    private long[] lazy;    // pending addition for the node's children
    private int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        square = new long[4 * n];
        lazy = new long[4 * n];

        int[] lastSeen = new int[100001];   // previous index of each value, plus 1
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int from = lastSeen[nums[i]];

            // every subarray [l..i] with l >= from gains one distinct value
            update(1, 0, n - 1, from, i);

            lastSeen[nums[i]] = i + 1;

            // positions beyond i are still 0, so the root holds sum of f[l]^2 for l <= i
            answer = (answer + square[1]) % MOD;
        }

        return (int) answer;
    }

    private void update(int node, int start, int end, int ql, int qr) {
        if (ql > end || qr < start) {
            return;
        }

        if (ql <= start && end <= qr) {
            apply(node, start, end, 1);
            return;
        }

        pushDown(node, start, end);

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, ql, qr);
        update(node * 2 + 1, mid + 1, end, ql, qr);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        square[node] = (square[node * 2] + square[node * 2 + 1]) % MOD;
    }

    // Add `value` to every element in [start, end] covered by this node.
    private void apply(int node, int start, int end, long value) {
        long length = end - start + 1L;

        // sum (x + v)^2 = sum x^2 + 2*v*sum x + v^2 * length  (uses the old sum, so update square first)
        square[node] = (square[node]
                + 2 * value % MOD * sum[node] % MOD
                + value * value % MOD * length % MOD) % MOD;

        sum[node] = (sum[node] + value * length) % MOD;
        lazy[node] = (lazy[node] + value) % MOD;
    }

    private void pushDown(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        apply(node * 2, start, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, end, lazy[node]);

        lazy[node] = 0;
    }
}
