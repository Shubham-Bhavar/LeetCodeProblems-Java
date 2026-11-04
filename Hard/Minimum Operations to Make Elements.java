
/*
 * LeetCode 3505 - Minimum Operations to Make Elements
 * Within K Subarrays Equal
 *
 * Difficulty: Hard
 * Approach: Fenwick Tree + Sliding Window + DP
 * Time: O(n log n + n * k)
 * Space: O(n)
 */

import java.util.*;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int[] a = nums.clone();
        Arrays.sort(a);

        int[] vals = Arrays.stream(a).distinct().toArray();
        int m = vals.length;

        long[] bitC = new long[m + 1], bitS = new long[m + 1];
        long[] cost = new long[n - x + 1];
        long sum = 0;

        for (int i = 0; i < x; i++) {
            int p = Arrays.binarySearch(vals, nums[i]) + 1;
            update(bitC, p, 1);
            update(bitS, p, nums[i]);
            sum += nums[i];
        }

        for (int i = 0; i <= n - x; i++) {
            int lo = 1, hi = m, target = (x + 1) / 2;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (query(bitC, mid) >= target) hi = mid;
                else lo = mid + 1;
            }

            long med = vals[lo - 1];
            long lc = query(bitC, lo), ls = query(bitS, lo);

            cost[i] = med * lc - ls + (sum - ls) - med * (x - lc);

            if (i < n - x) {
                int p1 = Arrays.binarySearch(vals, nums[i]) + 1;
                int p2 = Arrays.binarySearch(vals, nums[i + x]) + 1;

                update(bitC, p1, -1);
                update(bitS, p1, -nums[i]);
                update(bitC, p2, 1);
                update(bitS, p2, nums[i + x]);

                sum += (long) nums[i + x] - nums[i];
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[] dp = new long[n + 1], next = new long[n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(next, INF);

            for (int i = 1; i <= n; i++) {
                next[i] = next[i - 1];

                if (i >= x && dp[i - x] != INF) {
                    next[i] = Math.min(next[i],
                            dp[i - x] + cost[i - x]);
                }
            }

            long[] temp = dp;
            dp = next;
            next = temp;
        }

        return dp[n];
    }

    private void update(long[] bit, int i, long val) {
        while (i < bit.length) {
            bit[i] += val;
            i += i & -i;
        }
    }

    private long query(long[] bit, int i) {
        long sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & -i;
        }
        return sum;
    }
}
