```java
/*
    LeetCode 190 - Reverse Bits

    Problem:
    Reverse the bits of a given 32-bit unsigned integer.

    Example 1:
    Input:
    n = 43261596

    Binary:
    00000010100101000001111010011100

    Output:
    964176192

    Reversed Binary:
    00111001011110000010100101000000


    Example 2:
    Input:
    n = 2147483644

    Binary:
    01111111111111111111111111111100

    Output:
    1073741822

    Reversed Binary:
    00111111111111111111111111111110


    Approach:
    We process all 32 bits one by one.

    1. Take the last bit of n using:
       n & 1

    2. Shift the result left to make space for the new bit.

    3. Add the extracted bit to result.

    4. Shift n right by 1 bit.

    Repeat this process exactly 32 times.


    Example:
    n = 1011

    Extract bits from right to left:
    1 → 1 → 0 → 1

    Put them into result from left to right.


    Complexity:
    Time  : O(32) -> O(1)
    Space : O(1)
*/

class Solution {
    public int reverseBits(int n) 
    {
        int result = 0;

        for(int i = 0; i < 32; i++)
        {
            // Get the last bit
            int bit = n & 1;

            // Shift result left and add the bit
            result = (result << 1) | bit;

            // Move to the next bit
            n = n >>> 1;
        }

        return result;
    }
}
```
