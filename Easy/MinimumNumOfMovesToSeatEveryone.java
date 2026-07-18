// Question:
// You are given two arrays:
// seats[] and students[]
// You can move students left or right by 1 step.
// Find the minimum total moves required so that each student sits in a seat.

import java.util.Arrays;

class Solution {

    public int minMovesToSeat(int[] seats, int[] students) {

        // Step 1: Sort both arrays
        // Reason: pairing smallest with smallest gives minimum moves
        Arrays.sort(seats);
        Arrays.sort(students);

        int moves = 0;

        // Step 2: Match each student to corresponding seat
        for (int i = 0; i < seats.length; i++) {

            // Add absolute distance between seat and student
            moves += Math.abs(seats[i] - students[i]);
        }

        // Step 3: return total moves
        return moves;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] seats = {3, 1, 5};
        int[] students = {2, 7, 4};

        System.out.println(obj.minMovesToSeat(seats, students)); // Output: 4
    }
}
