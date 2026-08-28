/*
LeetCode: Elevator Requests I

Problem:
Given a building with floors numbered from 0 to n - 1 and an array
of floor requests, calculate the total time required for an elevator
to serve all requests in the given order.

Rules:
- The elevator starts at floor 0.
- It moves one floor per second.
- It serves requests in the given order.
- If it is already on the requested floor, no movement is needed.

Example:
Input:
n = 5
requests = [2, 1, 4, 3]

Movement:
0 -> 2 = 2 seconds
2 -> 1 = 1 second
1 -> 4 = 3 seconds
4 -> 3 = 1 second

Total Time = 2 + 1 + 3 + 1 = 7

Approach:
1. Start the elevator at floor 0.
2. For each requested floor, find the distance from the current floor.
3. Add the absolute difference to the total time.
4. Update the current floor.
5. Return the total time.

Time Complexity: O(requests.length)
Space Complexity: O(1)
*/

class Solution {
    public int totalTime(int n, int[] requests) {

        int currentFloor = 0;
        int totalTime = 0;

        for (int floor : requests) {

            // Add distance between current floor and requested floor
            totalTime += Math.abs(floor - currentFloor);

            // Update current elevator position
            currentFloor = floor;
        }

        return totalTime;
    }
}
