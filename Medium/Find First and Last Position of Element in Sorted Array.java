    /*
        LeetCode 34 - Find First and Last Position
        of Element in Sorted Array

        Approach:
        ----------
        Use Binary Search twice.

        1. Find first occurrence of target.
        2. Find last occurrence of target.

        First occurrence:
        If target is found, move RIGHT pointer left.

        Last occurrence:
        If target is found, move LEFT pointer right.

        Time Complexity: O(log n)
        Space Complexity: O(1)
    */
class Solution {

    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    // Find first occurrence
    private int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                answer = mid;

                // Search further left
                right = mid - 1;
            }
            else if (nums[mid] < target) {

                // Target is on right side
                left = mid + 1;
            }
            else {

                // Target is on left side
                right = mid - 1;
            }
        }

        return answer;
    }

    // Find last occurrence
    private int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                answer = mid;

                // Search further right
                left = mid + 1;
            }
            else if (nums[mid] < target) {

                // Target is on right side
                left = mid + 1;
            }
            else {

                // Target is on left side
                right = mid - 1;
            }
        }

        return answer;
    }
}
