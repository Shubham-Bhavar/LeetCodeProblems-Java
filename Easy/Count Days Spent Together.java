/**
 * LeetCode 2409: Count Days Spent Together
 *
 * Approach:
 * Convert dates to day numbers and calculate the overlapping days.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int start = Math.max(days(arriveAlice), days(arriveBob));
        int end = Math.min(days(leaveAlice), days(leaveBob));

        return Math.max(0, end - start + 1);
    }

    private int days(String date) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));

        for (int i = 0; i < month - 1; i++) {
            day += months[i];
        }

        return day;
    }
}
