/**
 * 3934. Smallest Unique Subarray (Hard)
 * https://leetcode.com/problems/smallest-unique-subarray/
 *
 * Approach: Binary search on length + double rolling hash.
 *   - If some subarray of length L is unique, every longer length also has a
 *     unique subarray, so the answer can be binary searched.
 *   - For a fixed L, hash every window in O(1) using prefix hashes and count them.
 *
 * Time:  O(n log n)
 * Space: O(n)
 */
class Solution {
    private static final long M1 = 1_000_000_007L;
    private static final long M2 = 998_244_353L;

    private long[] h1, h2, p1, p2;
    private int n;

    public int smallestUniqueSubarray(int[] nums) {
        n = nums.length;
        Random r = new Random();
        long b1 = 100_003 + r.nextInt(1_000_000);
        long b2 = 100_003 + r.nextInt(1_000_000);

        h1 = new long[n + 1];
        h2 = new long[n + 1];
        p1 = new long[n + 1];
        p2 = new long[n + 1];
        p1[0] = p2[0] = 1;
        for (int i = 0; i < n; i++) {
            h1[i + 1] = (h1[i] * b1 + nums[i]) % M1;
            h2[i + 1] = (h2[i] * b2 + nums[i]) % M2;
            p1[i + 1] = p1[i] * b1 % M1;
            p2[i + 1] = p2[i] * b2 % M2;
        }

        int lo = 1, hi = n; // the whole array (length n) is always unique
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasUnique(mid)) hi = mid; // works, try shorter
            else lo = mid + 1;            // fails, go longer
        }
        return lo;
    }

    /** Returns true if some subarray of length L appears exactly once. */
    private boolean hasUnique(int L) {
        HashMap<Long, Integer> count = new HashMap<>();
        for (int i = 0; i + L <= n; i++) {
            long a = ((h1[i + L] - h1[i] * p1[L]) % M1 + M1) % M1;
            long b = ((h2[i + L] - h2[i] * p2[L]) % M2 + M2) % M2;
            count.merge(a * M2 + b, 1, Integer::sum); // pack both hashes into one key
        }
        for (int c : count.values()) {
            if (c == 1) return true;
        }
        return false;
    }

    // Local test runner (LeetCode ignores this).
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] tests = { {3, 3, 3}, {2, 1, 2, 3, 3}, {1, 1, 2, 2, 1} };
        int[] expected = { 3, 1, 2 };
        for (int t = 0; t < tests.length; t++) {
            int got = s.smallestUniqueSubarray(tests[t]);
            System.out.printf("Example %d: got %d, expected %d %s%n",
                    t + 1, got, expected[t], got == expected[t] ? "PASS" : "FAIL");
        }
    }
}
