/*
Question:
Find the repeating number and the missing number in the grid.

Example:
grid = [[1, 3],
        [2, 2]]

Numbers should be: 1, 2, 3, 4

2 is repeated
4 is missing

Output: [2, 4]
*/

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int size = n * n;

        int[] frequency = new int[size + 1];

        // Count frequency of every number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                frequency[grid[i][j]]++;
            }
        }

        int repeated = 0;
        int missing = 0;

        // Find repeated and missing numbers
        for (int i = 1; i <= size; i++) {

            if (frequency[i] == 2) {
                repeated = i;
            }

            if (frequency[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeated, missing};
    }
}
