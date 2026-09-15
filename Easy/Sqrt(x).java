```java
/*
    LeetCode 69 - Sqrt(x)

    Problem:
    Given a non-negative integer x, return the square root of x
    rounded down to the nearest integer.

    You must not use any built-in exponent function.

    Example 1:
    Input:  x = 4
    Output: 2

    Example 2:
    Input:  x = 8
    Output: 2

    Explanation:
    √8 = 2.828...
    After rounding down, the answer is 2.

    --------------------------------------------------

    Approach:
    Use Binary Search.

    We search for the largest number whose square is
    less than or equal to x.

    If:
        mid * mid == x
            → return mid

        mid * mid < x
            → mid can be the answer
            → search on the right side

        mid * mid > x
            → search on the left side

    We use long for square because mid * mid can
    exceed the int range.

    --------------------------------------------------

    Time Complexity:
    O(log x)

    Space Complexity:
    O(1)
*/

class Solution {
    public int mySqrt(int x) 
    {
        if (x < 2)
        {
            return x;
        }

        int left = 1;
        int right = x / 2;
        int answer = 0;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            // Use long to avoid integer overflow
            long square = (long) mid * mid;

            if (square == x)
            {
                return mid;
            }
            else if (square < x)
            {
                answer = mid;
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return answer;
    }
}
```
