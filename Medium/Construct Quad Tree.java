/*
 * Problem: 427. Construct Quad Tree
 * Difficulty: Medium
 *
 * Approach:
 * 1. Check whether the current grid area contains the same values.
 * 2. If all values are same, create a leaf node.
 * 3. Otherwise, divide the area into four equal parts.
 * 4. Recursively construct all four children.
 *
 * Time Complexity: O(n * n * log n)
 * Space Complexity: O(log n) recursion stack, excluding the tree
 */

class Solution {

    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int row, int col, int size) {

        // Check whether all values in this area are same
        boolean same = true;
        int value = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != value) {
                    same = false;
                    break;
                }
            }

            if (!same) {
                break;
            }
        }

        // If all values are same, create a leaf node
        if (same) {
            return new Node(value == 1, true);
        }

        // Divide the grid into four parts
        int half = size / 2;

        Node root = new Node(true, false);

        root.topLeft = build(grid, row, col, half);

        root.topRight = build(grid, row, col + half, half);

        root.bottomLeft = build(grid, row + half, col, half);

        root.bottomRight = build(grid, row + half, col + half, half);

        return root;
    }
}
