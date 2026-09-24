/*
    LeetCode 54 - Spiral Matrix

    Problem:
    --------
    Given an m x n matrix, return all elements of the matrix
    in spiral order.

    Example 1:
    Input:
    [[1,2,3],
     [4,5,6],
     [7,8,9]]

    Output:
    [1,2,3,6,9,8,7,4,5]

    Example 2:
    Input:
    [[1,2,3,4],
     [5,6,7,8],
     [9,10,11,12]]

    Output:
    [1,2,3,4,8,12,11,10,9,5,6,7]

    Approach:
    ---------
    Use four boundaries:

        top    -> first remaining row
        bottom -> last remaining row
        left   -> first remaining column
        right  -> last remaining column

    Traverse in this order:
        1. Left -> Right
        2. Top -> Bottom
        3. Right -> Left
        4. Bottom -> Top

    After each traversal, move the corresponding boundary inward.

    Time Complexity: O(m * n)
    Space Complexity: O(1) excluding the output list.
*/
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right)
        {
            // Left -> Right
            for (int i = left; i <= right; i++)
            {
                result.add(matrix[top][i]);
            }
            top++;

            // Top -> Bottom
            for (int i = top; i <= bottom; i++)
            {
                result.add(matrix[i][right]);
            }
            right--;

            // Right -> Left
            if (top <= bottom)
            {
                for (int i = right; i >= left; i--)
                {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Bottom -> Top
            if (left <= right)
            {
                for (int i = bottom; i >= top; i--)
                {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
