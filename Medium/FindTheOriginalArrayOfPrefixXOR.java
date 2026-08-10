/*
Q) You are given an integer array pref[] of size n.
   Find the array arr[] such that:

   pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i]

   Where ^ is bitwise XOR.

   It is guaranteed that the answer is unique.

Example:
Input:  pref = [5,2,0,3,1]
Output: arr  = [5,7,2,3,2]

Key Concept:
arr[i] = pref[i] ^ pref[i-1]
*/

class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];

        // First element is same as pref
        arr[0] = pref[0];

        // Compute remaining elements
        for (int i = 1; i < n; i++) {
            arr[i] = pref[i] ^ pref[i - 1];
        }

        return arr;
    }
}
