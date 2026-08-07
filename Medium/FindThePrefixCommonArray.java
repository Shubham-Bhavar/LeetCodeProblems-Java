/*
Q) You are given two 0-indexed integer permutations A and B of length n.

A prefix common array C is defined such that:
C[i] = count of numbers that are present in BOTH arrays A and B
from index 0 to i (inclusive).

Return the prefix common array.

-----------------------------------------------------

Example:
A = [1,3,2,4]
B = [3,1,2,4]

Output: [0,2,3,4]

-----------------------------------------------------

Approach:
- Use a frequency array to track occurrences of numbers
- If any number appears twice → it means it is present in both A and B
- Maintain a count of such numbers
- Store count at each index

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;

        // freq[x] = count of how many times x has appeared in A and B
        int[] freq = new int[n + 1];

        // result array to store answer
        int[] result = new int[n];

        int count = 0; // number of common elements

        // loop through arrays
        for (int i = 0; i < n; i++) {

            // add element from A
            freq[A[i]]++;

            // if it becomes 2 → it means it appeared in both arrays
            if (freq[A[i]] == 2) {
                count++;
            }

            // add element from B
            freq[B[i]]++;

            // check again for B
            if (freq[B[i]] == 2) {
                count++;
            }

            // store current count
            result[i] = count;
        }

        return result;
    }
}
