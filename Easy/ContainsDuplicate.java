/*
LeetCode 217 - Contains Duplicate

Given an integer array nums, return true if any value
appears at least twice in the array, otherwise return false.
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {

        // Store unique elements
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            // Duplicate found
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        // No duplicates found
        return false;
    }
}
