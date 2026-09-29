/*
 * ============================================================
 * LeetCode 2267: Check if There Is a Valid Parentheses String Path
 * ============================================================
 *
 * Difficulty: Hard
 * Topics: Array, Dynamic Programming, DFS, Memoization, Matrix
 *
 * ------------------------------------------------------------
 * Problem Statement:
 * ------------------------------------------------------------
 *
 * You are given an m x n matrix of parentheses grid.
 *
 * A valid parentheses string path:
 *
 * 1. Starts from the upper-left cell (0, 0).
 * 2. Ends at the bottom-right cell (m - 1, n - 1).
 * 3. Can move only Down or Right.
 * 4. The string formed by the path must be a valid
 *    parentheses string.
 *
 * A parentheses string is valid if:
 *
 * - It is "()".
 * - It can be written as AB, where A and B are valid strings.
 * - It can be written as (A), where A is a valid string.
 *
 * Return true if there exists at least one valid parentheses
 * string path. Otherwise, return false.
 *
 * ------------------------------------------------------------
 * Example 1:
 * ------------------------------------------------------------
 *
 * Input:
 * grid = [
 *     ["(","(","("],
 *     [")","(",")"],
 *     ["(","(",")"],
 *     ["(","(",")"]
 * ]
 *
 * Output:
 * true
 *
 * Explanation:
 * There are paths that form valid parentheses strings such as:
 *
 * "()(())"
 * "((()))"
 *
 * ------------------------------------------------------------
 * Example 2:
 * ------------------------------------------------------------
 *
 * Input:
 * grid = [
 *     [")",")"],
 *     ["(","("]
 * ]
 *
 * Output:
 * false
 *
 * Explanation:
 * The possible paths form:
 *
 * "))("
 * ")(("
 *
 * Neither is a valid parentheses string.
 *
 * ------------------------------------------------------------
 * Constraints:
 * ------------------------------------------------------------
 *
 * 1 <= m, n <= 100
 * grid[i][j] is either '(' or ')'
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * We use DFS + Memoization.
 *
 * For every path, maintain a variable called "balance".
 *
 * '(' -> balance + 1
 * ')' -> balance - 1
 *
 * A valid parentheses string must satisfy:
 *
 * 1. Balance should never become negative.
 * 2. Final balance must be exactly 0.
 *
 * At every cell, we have two choices:
 *
 * - Move Down
 * - Move Right
 *
 * The same state can be reached multiple times.
 *
 * A state is represented by:
 *
 *     row, column, balance
 *
 * So we store the result of every state in:
 *
 *     dp[row][column][balance]
 *
 * If the same state is encountered again, we directly return
 * the previously calculated result.
 *
 * ------------------------------------------------------------
 * Important Optimizations:
 * ------------------------------------------------------------
 *
 * 1. Path length must be even.
 *
 *    A valid parentheses string always has even length.
 *
 *    Path length = m + n - 1
 *
 * 2. The first character must be '('.
 *
 * 3. If balance becomes negative, the path is invalid.
 *
 * 4. If there are not enough remaining cells to close all
 *    currently open parentheses, the path can be stopped early.
 *
 * ------------------------------------------------------------
 * Complexity:
 * ------------------------------------------------------------
 *
 * Number of possible states:
 *
 *     O(m * n * (m + n))
 *
 * Time Complexity:
 *     O(m * n * (m + n))
 *
 * Space Complexity:
 *     O(m * n * (m + n))
 *
 * ------------------------------------------------------------
 * Key Pattern:
 * ------------------------------------------------------------
 *
 * Grid Path + Condition
 *         ↓
 * DFS / Backtracking
 *         ↓
 * Add State
 *         ↓
 * Memoization
 *
 * State = (row, column, balance)
 *
 * ============================================================
 */

class Solution {

    // dp[row][column][balance]
    private Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        /*
         * A valid parentheses string always has even length.
         *
         * Number of cells in any path = m + n - 1
         */
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        /*
         * A valid parentheses string cannot start with ')'.
         */
        if (grid[0][0] == ')') {
            return false;
        }

        /*
         * Maximum possible balance is m + n.
         */
        dp = new Boolean[m][n][m + n];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid,
                        int row,
                        int col,
                        int balance) {

        int m = grid.length;
        int n = grid[0].length;

        /*
         * Update balance according to current character.
         */
        if (grid[row][col] == '(') {
            balance++;
        } else {
            balance--;
        }

        /*
         * A valid parentheses string can never have
         * negative balance.
         */
        if (balance < 0) {
            return false;
        }

        /*
         * If the remaining cells are not enough to close
         * all currently open parentheses, this path is impossible.
         */
        int remainingCells = (m - row) + (n - col) - 1;

        if (balance > remainingCells) {
            return false;
        }

        /*
         * If we reached the bottom-right cell,
         * the balance must be exactly 0.
         */
        if (row == m - 1 && col == n - 1) {
            return balance == 0;
        }

        /*
         * If this state has already been calculated,
         * return the stored answer.
         */
        if (dp[row][col][balance] != null) {
            return dp[row][col][balance];
        }

        /*
         * Try moving DOWN.
         */
        if (row + 1 < m) {

            if (dfs(grid, row + 1, col, balance)) {
                return dp[row][col][balance] = true;
            }
        }

        /*
         * Try moving RIGHT.
         */
        if (col + 1 < n) {

            if (dfs(grid, row, col + 1, balance)) {
                return dp[row][col][balance] = true;
            }
        }

        /*
         * Neither Down nor Right produced a valid path.
         */
        return dp[row][col][balance] = false;
    }
}
