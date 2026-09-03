/*
Problem:
For every index i, find how many elements after i
have different parity.

Even -> nums[i] % 2 == 0
Odd  -> nums[i] % 2 != 0

Approach:
Scan from right to left.

Keep:
even = number of even elements to the right
odd  = number of odd elements to the right

If current number is even:
    score = odd

If current number is odd:
    score = even
*/

class Solution {
    public int[] scoreArray(int[] nums) 
    {
        int n = nums.length;
        int[] answer = new int[n];

        int even = 0;
        int odd = 0;

        for(int i = n - 1; i >= 0; i--)
        {
            if(nums[i] % 2 == 0)
            {
                answer[i] = odd;
                even++;
            }
            else
            {
                answer[i] = even;
                odd++;
            }
        }

        return answer;
    }
}
