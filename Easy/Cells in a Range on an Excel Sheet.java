
/*
 * LeetCode 2194: Cells in a Range on an Excel Sheet
 *
 * Problem:
 * Given a range like "K1:L2", return all cell names
 * sorted by column first, then by row.
 *
 * Approach:
 * 1. Extract starting and ending columns and rows.
 * 2. Iterate through columns in alphabetical order.
 * 3. For each column, iterate through rows in ascending order.
 * 4. Add each cell name to the result list.
 *
 * Time Complexity: O(C * R)
 * Space Complexity: O(C * R) for the result.
 *
 * C = number of columns
 * R = number of rows
 */

import java.util.*;

class Solution {
    public List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();

        char startCol = s.charAt(0);
        char endCol = s.charAt(3);

        int startRow = s.charAt(1) - '0';
        int endRow = s.charAt(4) - '0';

        for (char col = startCol; col <= endCol; col++) {
            for (int row = startRow; row <= endRow; row++) {
                result.add("" + col + row);
            }
        }

        return result;
    }
}
