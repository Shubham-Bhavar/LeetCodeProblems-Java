/*
    LeetCode 2125 - Number of Laser Beams in a Bank

    Problem:
    --------
    Given a binary string array representing a bank floor plan,
    count the total number of laser beams between security devices.

    A laser beam exists between two different rows if:
    - Both rows contain security devices.
    - Every row between them contains no security devices.

    Example:
    Input:  bank = ["011001","000000","010100","001000"]
    Output: 8

    Approach:
    ---------
    Count the number of security devices in each row.

    If the current row has devices and the previous non-empty row
    has devices, then every device in the two rows forms a beam.

        beams = previousDevices * currentDevices

    Then make the current row the previous non-empty row.

    Time Complexity:
    O(m * n)

    Space Complexity:
    O(1)
*/

class Solution {
    public int numberOfBeams(String[] bank) {

        int previousDevices = 0;
        int beams = 0;

        for (String row : bank) {

            int currentDevices = 0;

            // Count security devices in current row
            for (char ch : row.toCharArray()) {
                if (ch == '1') {
                    currentDevices++;
                }
            }

            // Empty row -> ignore it
            if (currentDevices == 0) {
                continue;
            }

            // Every device in both non-empty rows forms a beam
            beams += previousDevices * currentDevices;

            // Current row becomes previous non-empty row
            previousDevices = currentDevices;
        }

        return beams;
    }
}
