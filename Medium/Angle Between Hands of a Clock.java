/**
 * LeetCode 1344: Angle Between Hands of a Clock
 *
 * Approach:
 * 1. The minute hand moves 6 degrees per minute.
 * 2. The hour hand moves 30 degrees per hour and 0.5 degrees per minute.
 * 3. Calculate the positions of both hands.
 * 4. Find the absolute difference and return the smaller angle.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = (hour % 12) * 30 + minutes * 0.5;
        double minuteAngle = minutes * 6;

        double angle = Math.abs(hourAngle - minuteAngle);

        return Math.min(angle, 360 - angle);
    }
}
