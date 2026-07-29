/**
 * Problem: Traffic Signal State
 *
 * Description:
 * Given an integer timer (in seconds), determine the state of a traffic signal:
 * - If timer == 0      → "Green"
 * - If timer == 30     → "Orange"
 * - If 30 < timer <= 90 → "Red"
 * - Otherwise          → "Invalid"
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public String trafficSignal(int timer) {
        if (timer == 0) {
            return "Green";
        } else if (timer == 30) {
            return "Orange";
        } else if (timer > 30 && timer <= 90) {
            return "Red";
        } else {
            return "Invalid";
        }
    }
}
