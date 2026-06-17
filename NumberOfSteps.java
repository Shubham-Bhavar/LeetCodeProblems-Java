/*
Question:
Given a number num.

If num is even, divide it by 2.
If num is odd, subtract 1.

Return the number of steps
required to make num equal to 0.
*/

class Solution {

    public int numberOfSteps(int num) {

        // Store total steps
        int steps = 0;

        // Repeat until num becomes 0
        while (num > 0) {

            // If even
            if (num % 2 == 0) {
                num = num / 2;
            }
            // If odd
            else {
                num = num - 1;
            }

            // Increase step count
            steps++;
        }

        return steps;
    }
}
