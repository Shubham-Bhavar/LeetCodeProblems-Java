/*
LeetCode 2053 - Kth Distinct String in an Array

Problem:
A distinct string is a string that appears exactly once in the array.

Given:
- String array arr
- Integer k

Return the kth distinct string in the order in which
the strings appear in arr.

If fewer than k distinct strings exist, return "".

Example:
Input:  arr = ["d","b","c","b","c","a"], k = 2
Output: "a"

Approach:
1. Use HashMap to store the frequency of each string.
2. Traverse the array again in the original order.
3. If a string occurs exactly once, increase count.
4. When count becomes k, return that string.
5. If no kth distinct string exists, return "".

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public String kthDistinct(String[] arr, int k) 
    {
        HashMap<String, Integer> map = new HashMap<>();

        // Count frequency of each string
        for(String str : arr)
        {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        // Find kth distinct string in original order
        int count = 0;

        for(String str : arr)
        {
            if(map.get(str) == 1)
            {
                count++;

                if(count == k)
                {
                    return str;
                }
            }
        }

        return "";
    }
}
