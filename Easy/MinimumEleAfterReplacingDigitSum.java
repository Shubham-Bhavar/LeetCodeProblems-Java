/*
Q: Replace every number with sum of its digits
   and return the minimum value in the array
*/

class Solution {
    public int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;   // start with very large value

        for (int num : nums) {

            int sum = 0;

            // find sum of digits
            while (num > 0) {
                sum += num % 10;       // take last digit
                num /= 10;             // remove last digit
            }

            // update minimum
            min = Math.min(min, sum);
        }

        return min;                    // final minimum
    }
}
