/*Q) An integer divisible by the sum of its digits is called a Harshad number.

Given an integer x, return the sum of its digits if x is a Harshad number,
otherwise return -1.*/


class Solution {
    public int harshadNumber(int x) {
        int sum = 0, temp = x;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        if (x % sum == 0) return sum;
        return -1;
    }
}
