/*
Question:
Given an encoded array and the first element of the original array,
decode and return the original array.

Formula:
encoded[i] = arr[i] XOR arr[i + 1]

Therefore:
arr[i + 1] = arr[i] XOR encoded[i]
*/

class Solution {
    public int[] decode(int[] encoded, int first) {

        int n = encoded.length;

        int[] arr = new int[n + 1];

        // Store the first element
        arr[0] = first;

        // Decode the remaining elements
        for (int i = 0; i < n; i++) {
            arr[i + 1] = arr[i] ^ encoded[i];
        }

        return arr;
    }
}
