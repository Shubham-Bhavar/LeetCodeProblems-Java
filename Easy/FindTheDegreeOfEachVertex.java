/*
PROBLEM: Find Degree of Each Vertex in Undirected Graph

Understanding:
- Graph is given as adjacency matrix
- matrix[i][j] = 1 means edge between i and j
- Since graph is undirected:
  matrix[i][j] == matrix[j][i]

Degree of vertex:
- Number of edges connected to it
- In matrix → count of 1s in that row

Steps:
1. Create result array of size n
2. For each vertex i:
   - Traverse row i
   - Count number of 1s
3. Store count in ans[i]

Example:
matrix = [[0,1,1],
          [1,0,1],
          [1,1,0]]

Row 0 → 2 ones → degree 2
Row 1 → 2 ones → degree 2
Row 2 → 2 ones → degree 2

Result: [2,2,2]

Time Complexity: O(n^2)
Space Complexity: O(n)
*/

class Solution {
    public int[] findDegree(int[][] matrix) {

        int n = matrix.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int degree = 0;

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    degree++;
                }
            }

            ans[i] = degree;
        }

        return ans;
    }
}
