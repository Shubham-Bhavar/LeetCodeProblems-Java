/**
 * 🧠 Problem:
 * Count digits in num that evenly divide num.
 *
 * 📥 Input:
 * num = 121
 *
 * 📤 Output:
 * 2
 *
 * ⚡ Approach:
 * - Extract each digit using modulo (%10)
 * - Check if num % digit == 0
 * - Count valid digits
 *
 * ⏱ Time: O(d)  (d = number of digits)
 * ⏱ Space: O(1)
 */

class Solution {
    public int countDigits(int num) {

        int original = num;
        int count = 0;

        while (num > 0) {
            int digit = num % 10;

            if (original % digit == 0) {
                count++;
            }

            num /= 10;
        }

        return count;
    }
}
