/*Q) You are given two integers n and t.

Return the smallest number ≥ n such that the product of its digits is divisible by t.*/

class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;

        while (true) {
            int product = 1;
            int temp = num;

            while (temp > 0) {
                product *= (temp % 10);
                temp /= 10;
            }

            if (product % t == 0) return num;
            num++;
        }
    }
}
