/*
LeetCode 3986 - Number of Elapsed Seconds Between Two Times

Problem:
Given two valid times startTime and endTime in the format "HH:MM:SS",
return the number of seconds elapsed from startTime to endTime.

Example 1:
Input:
startTime = "01:00:00"
endTime   = "01:00:25"

Output:
25

Example 2:
Input:
startTime = "12:34:56"
endTime   = "13:00:00"

Output:
1504

Approach:
1. Convert both times into total seconds from 00:00:00.
2. For each time:
   total seconds = hours * 3600 + minutes * 60 + seconds
3. Return:
   endTimeSeconds - startTimeSeconds

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int countSeconds(String startTime, String endTime) {
        int start = toSeconds(startTime);
        int end = toSeconds(endTime);

        return end - start;
    }

    private int toSeconds(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        int seconds = Integer.parseInt(time.substring(6, 8));

        return hours * 3600 + minutes * 60 + seconds;
    }
}
