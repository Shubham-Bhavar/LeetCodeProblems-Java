/*
Question:
Take every number in nums, reverse its digits,
and add the reversed number to the array.

Return the number of distinct integers
in the final array.

Example:
nums = [1, 13, 10, 12, 31]

Reversed:
1 -> 1
13 -> 31
10 -> 1
12 -> 21
31 -> 13

Distinct numbers:
1, 10, 12, 13, 21, 31

Output: 6
*/

import java.util.HashSet;

class Solution {

    public int countDistinctIntegers(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            // Add original number
            set.add(num);

            // Reverse the number and add it
            int reversed = 0;
            int temp = num;

            while (temp > 0) {
                int digit = temp % 10;
                reversed = reversed * 10 + digit;
                temp /= 10;
            }

            set.add(reversed);
        }

        return set.size();
    }
}
