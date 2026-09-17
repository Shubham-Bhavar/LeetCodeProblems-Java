/*
LeetCode 118. Pascal's Triangle

Difficulty: Easy

Problem Statement:
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly
above it.

Example 1:
Input: numRows = 5

Output:
[[1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]]

Example 2:
Input: numRows = 1

Output:
[[1]]

Approach:
1. Create an empty list to store all rows.
2. For every row, create a new list.
3. The first and last elements of every row are 1.
4. Every middle element is the sum of the two elements from the previous row.
5. Add the row to the result.

Time Complexity: O(numRows^2)
Space Complexity: O(numRows^2) for the output
*/

import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int value = result.get(i - 1).get(j - 1)
                              + result.get(i - 1).get(j);

                    row.add(value);
                }
            }

            result.add(row);
        }

        return result;
    }
}