/*
LeetCode 3195 - Find the Minimum Area to Cover All Ones I

Problem:
You are given a 2D binary array grid.
Find a rectangle with horizontal and vertical sides
with the smallest area such that all 1's in grid lie inside it.

Return the minimum possible area.

Example 1:
Input:
grid = [[0,1,0],
        [1,0,1]]

Output:
6

Explanation:
The smallest rectangle has:
Height = 2
Width = 3
Area = 2 * 3 = 6

Example 2:
Input:
grid = [[1,0],
        [0,0]]

Output:
1


Approach:
1. Traverse the complete grid.
2. For every cell containing 1:
   - Find minimum row.
   - Find maximum row.
   - Find minimum column.
   - Find maximum column.
3. Calculate:
   height = maxRow - minRow + 1
   width  = maxCol - minCol + 1
4. Return height * width.

Why +1?
If the minimum row and maximum row are the same,
the height must be 1, not 0.

Example:
minRow = 2, maxRow = 2
height = 2 - 2 + 1 = 1


Time Complexity: O(m * n)
Space Complexity: O(1)
*/

class Solution {
    public int minimumArea(int[][] grid) {
        int minRow = grid.length;
        int maxRow = -1;

        int minCol = grid[0].length;
        int maxCol = -1;

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);

                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;

        return height * width;
    }
}
