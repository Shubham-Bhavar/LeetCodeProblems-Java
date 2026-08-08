/*
PROBLEM: Decompress Run-Length Encoded List

Given array nums where:
- nums[2*i] = freq
- nums[2*i+1] = val

Return decompressed list by repeating val freq times.

Example:
Input: [1,2,3,4]
Output: [2,4,4,4]
*/

class Solution {
    public int[] decompressRLElist(int[] nums) {

        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i + 1]);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
