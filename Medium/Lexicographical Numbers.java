/*
LeetCode 386 - Lexicographical Numbers

Example:
Input:  n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

Approach:
1. Start with 1.
2. Try to go deeper by multiplying current number by 10.
3. If that is not possible, increase the number.
4. If the number becomes greater than n, move back to
   the previous prefix and increase it.

Time:  O(n)
Space: O(1) extra space (excluding output)
*/

import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) 
    {
        List<Integer> ans = new ArrayList<>();

        int curr = 1;

        for(int i = 0; i < n; i++)
        {
            ans.add(curr);

            // Go deeper: 1 -> 10 -> 100
            if(curr * 10 <= n)
            {
                curr = curr * 10;
            }
            else
            {
                // Move to next number
                while(curr % 10 == 9 || curr + 1 > n)
                {
                    curr = curr / 10;
                }

                curr++;
            }
        }

        return ans;
    }
}
