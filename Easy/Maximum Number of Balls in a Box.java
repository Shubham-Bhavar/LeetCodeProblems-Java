/*
Question: Maximum Number of Balls in a Box

You are given two integers lowLimit and highLimit.

For every ball number, calculate the sum of its digits.
Place the ball into the box whose number equals that digit sum.

Return the maximum number of balls present in any box.

Example:
Input: lowLimit = 1, highLimit = 10
Output: 2

Explanation:
Ball 1  -> digit sum = 1
Ball 10 -> digit sum = 1

So, box 1 contains 2 balls, which is the maximum.
*/

class Solution {

    public int countBalls(int lowLimit, int highLimit) {
        int[] boxes = new int[46];
        int max = 0;

        for (int ball = lowLimit; ball <= highLimit; ball++) {
            int sum = digitSum(ball);

            boxes[sum]++;
            max = Math.max(max, boxes[sum]);
        }

        return max;
    }

    // Returns the sum of digits of a number
    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
