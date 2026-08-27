/*
============================================================
LEETCODE: Sum of Integers With Maximum Digit Range
============================================================

PROBLEM:
You are given an integer array nums.

The digit range of a number is:
Largest Digit - Smallest Digit

Return the sum of all integers whose digit range is equal
to the maximum digit range among all integers in the array.

============================================================
EXAMPLE:

Input:
nums = [5724, 111, 350]

DIGIT RANGE TABLE:

| Number | Largest Digit | Smallest Digit | Digit Range |
|--------|---------------|----------------|-------------|
| 5724   | 7             | 2              | 5           |
| 111    | 1             | 1              | 0           |
| 350    | 5             | 0              | 5           |

Maximum Digit Range = 5

Numbers with maximum range:
5724 + 350 = 6074

Output:
6074

============================================================
APPROACH:

1. Initialize maxRange = -1 and sum = 0.
2. For each number:
   - Find the maximum digit.
   - Find the minimum digit.
   - Calculate digit range = max - min.
3. If range > maxRange:
   - Update maxRange.
   - Reset sum = current number.
4. If range == maxRange:
   - Add the current number to sum.
5. Return sum.

============================================================
TIME COMPLEXITY:
O(n * d)

n = Number of elements
d = Number of digits in each number

SPACE COMPLEXITY:
O(1)

============================================================
*/

class Solution {
    public int maxDigitRange(int[] nums) {
        int sum = 0;
        int maxRange = -1;

        for (int num : nums) {
            int max = 0;
            int min = 9;
            int temp = num;

            // Find the largest and smallest digit
            while (temp > 0) {
                int digit = temp % 10;

                max = Math.max(max, digit);
                min = Math.min(min, digit);

                temp /= 10;
            }

            // Calculate digit range
            int range = max - min;

            // New maximum range found
            if (range > maxRange) {
                maxRange = range;
                sum = num;
            }
            // Another number with the same maximum range
            else if (range == maxRange) {
                sum += num;
            }
        }

        return sum;
    }
}
