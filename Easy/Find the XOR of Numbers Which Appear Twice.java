    /*
     * Question:
     * Return the XOR of all numbers that appear twice in nums.
     * Return 0 if no number appears twice.
     */
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int result = 0;

        for (int num : nums) {
            // If number is already seen, it appears twice
            if (seen.contains(num)) {
                result ^= num;
            } else {
                seen.add(num);
            }
        }

        return result;
    }
}
