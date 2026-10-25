```java
/**
 * Problem: Count Subarrays With Majority Element
 *
 * Approach:
 * 1. Convert target elements to +1 and other elements to -1.
 * 2. A subarray has target as its majority if its sum is positive.
 * 3. Use prefix sums and a Fenwick Tree (Binary Indexed Tree)
 *    to count previous prefix sums smaller than the current prefix.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int offset = n + 2;
        int[] bit = new int[2 * n + 5];

        long answer = 0;
        int prefix = 0;

        // Insert the initial prefix sum
        update(bit, offset);

        for (int num : nums) {
            prefix += (num == target) ? 1 : -1;

            // Count previous prefix sums strictly smaller than current
            answer += query(bit, prefix + offset - 1);

            // Insert current prefix sum
            update(bit, prefix + offset);
        }

        return answer;
    }

    private void update(int[] bit, int index) {
        while (index < bit.length) {
            bit[index]++;
            index += index & -index;
        }
    }

    private int query(int[] bit, int index) {
        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }

        return sum;
    }
}
```

**Commit message:**
```text
Add Fenwick Tree solution for Count Subarrays With Majority Element
```
