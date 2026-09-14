```java
/*
    LeetCode 36 - Valid Sudoku

    Problem:
    Determine if a 9 x 9 Sudoku board is valid.

    Rules:
    1. Each row must contain digits 1-9 without repetition.
    2. Each column must contain digits 1-9 without repetition.
    3. Each 3 x 3 sub-box must contain digits 1-9 without repetition.

    Note:
    - Only filled cells need to be validated.
    - '.' represents an empty cell.
    - A valid board does not necessarily mean the Sudoku is solvable.

    Example 1:
    Input:
    [
      ["5","3",".",".","7",".",".",".","."],
      ["6",".",".","1","9","5",".",".","."],
      [".","9","8",".",".",".",".","6","."],
      ["8",".",".",".","6",".",".",".","3"],
      ["4",".",".","8",".","3",".",".","1"],
      ["7",".",".",".","2",".",".",".","6"],
      [".","6",".",".",".",".","2","8","."],
      [".",".",".","4","1","9",".",".","5"],
      [".",".",".",".","8",".",".","7","9"]
    ]

    Output:
    true


    Example 2:
    Input:
    [
      ["8","3",".",".","7",".",".",".","."],
      ["6",".",".","1","9","5",".",".","."],
      [".","9","8",".",".",".",".","6","."],
      ["8",".",".",".","6",".",".",".","3"],
      ["4",".",".","8",".","3",".",".","1"],
      ["7",".",".",".","2",".",".",".","6"],
      [".","6",".",".",".",".","2","8","."],
      [".",".",".","4","1","9",".",".","5"],
      [".",".",".",".","8",".",".","7","9"]
    ]

    Output:
    false

    Explanation:
    There are two 8s in the top-left 3 x 3 box.


    Approach:
    - Use three boolean arrays:
        rows  -> stores numbers used in each row
        cols  -> stores numbers used in each column
        boxes -> stores numbers used in each 3 x 3 box
    - Visit every cell.
    - Ignore '.' cells.
    - Convert the digit into an index from 0 to 8.
    - Find the corresponding 3 x 3 box.
    - If the number already exists in the row, column, or box,
      the Sudoku is invalid.
    - Otherwise, mark the number as used.


    Box Formula:
    box = (row / 3) * 3 + (column / 3)


    Complexity:
    Time  : O(9 x 9) -> O(1)
    Space : O(9 x 9) -> O(1)
*/

class Solution {
    public boolean isValidSudoku(char[][] board) 
    {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                // Skip empty cells
                if(board[i][j] == '.')
                {
                    continue;
                }

                // Convert '1'-'9' into index 0-8
                int num = board[i][j] - '1';

                // Find the 3 x 3 box
                int box = (i / 3) * 3 + (j / 3);

                // Check duplicate in row, column or box
                if(rows[i][num] || cols[j][num] || boxes[box][num])
                {
                    return false;
                }

                // Mark number as used
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[box][num] = true;
            }
        }

        return true;
    }
}
```
