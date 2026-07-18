/*
Question:
Remove smallest elements until all elements >= k
Return minimum operations
*/

import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;

        // sort array
        Arrays.sort(nums);

        // remove elements smaller than k
        for (int num : nums) {
            if (num < k) count++;
            else break; // बाकी सर्व >= k
        }

        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println(obj.minOperations(new int[]{2,11,10,1,3}, 10)); // 3
        System.out.println(obj.minOperations(new int[]{1,1,2,4,9}, 1));   // 0
        System.out.println(obj.minOperations(new int[]{1,1,2,4,9}, 9));   // 4
    }
}
