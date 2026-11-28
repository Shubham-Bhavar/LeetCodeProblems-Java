
/*
 * LeetCode 319: Bulb Switcher
 *
 * Approach: Mathematics
 *
 * 1. Each bulb is toggled once for every divisor.
 * 2. Only perfect squares have an odd number of divisors.
 * 3. Therefore, only perfect square bulbs remain ON.
 * 4. Answer = floor(sqrt(n)).
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
