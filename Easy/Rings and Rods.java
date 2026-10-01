/*
 * LeetCode 2103: Rings and Rods
 *
 * Problem:
 * There are n rings and each ring is either red, green, or blue.
 * The rings are distributed across ten rods labeled from 0 to 9.
 *
 * Every two characters in the string "rings" represent one ring:
 * - First character = color ('R', 'G', 'B')
 * - Second character = rod number ('0' to '9')
 *
 * Return the number of rods that contain all three colors:
 * Red, Green, and Blue.
 *
 * Example 1:
 * Input:  rings = "B0B6G0R6R0R6G9"
 * Output: 1
 *
 * Explanation:
 * Rod 0 has Red, Green, and Blue.
 * Rod 6 has only Red and Blue.
 * Rod 9 has only Green.
 *
 * Example 2:
 * Input:  rings = "B0R0G0R9R0B0G0"
 * Output: 1
 *
 * Example 3:
 * Input:  rings = "G4"
 * Output: 0
 *
 * Constraints:
 * 1 <= n <= 100
 * rings.length == 2 * n
 *
 * Approach:
 * Use a 2D boolean array:
 *
 * colors[rod][0] -> Red
 * colors[rod][1] -> Green
 * colors[rod][2] -> Blue
 *
 * For every ring, mark its color on the corresponding rod.
 * Finally, count rods where all three colors are present.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int countPoints(String rings) {

        // 10 rods and 3 possible colors
        boolean[][] colors = new boolean[10][3];

        // Process every color-rod pair
        for (int i = 0; i < rings.length(); i += 2) {

            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - '0';

            if (color == 'R') {
                colors[rod][0] = true;
            } 
            else if (color == 'G') {
                colors[rod][1] = true;
            } 
            else {
                colors[rod][2] = true;
            }
        }

        int count = 0;

        // Check every rod
        for (int rod = 0; rod < 10; rod++) {

            if (colors[rod][0]
                    && colors[rod][1]
                    && colors[rod][2]) {

                count++;
            }
        }

        return count;
    }
}
