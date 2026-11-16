
/*
 * LeetCode 2243: Calculate Digit Sum of a String
 *
 * Problem Statement:
 * Given a numeric string s and an integer k, divide the string into
 * consecutive groups of size k.
 *
 * Replace each group with the sum of its digits and merge all group
 * results into a new string.
 *
 * Repeat this process until the string length becomes less than
 * or equal to k.
 *
 * Return the final string.
 *
 * Approach: String Simulation
 *
 * Step-by-Step Explanation:
 * 1. Continue processing while s.length() > k.
 * 2. Create a StringBuilder to store the new string.
 * 3. Divide s into groups of size k using a for loop.
 * 4. Calculate the sum of digits in each group.
 * 5. Append the sum to the StringBuilder.
 * 6. Update s with the newly generated string.
 * 7. Return s when its length becomes <= k.
 *
 * Note:
 * The last group may contain fewer than k characters.
 *
 * Time Complexity: O(n log_k(n))
 * Space Complexity: O(n)
 */

class Solution {
    public String digitSum(String s, int k) {

        while (s.length() > k) {

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < s.length(); i += k) {

                int sum = 0;

                for (int j = i; j < Math.min(i + k, s.length()); j++) {
                    sum += s.charAt(j) - '0';
                }

                result.append(sum);
            }

            s = result.toString();
        }

        return s;
    }
}
