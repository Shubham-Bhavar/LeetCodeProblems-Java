// Q: Sum of all odd-length subarrays

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int total = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                // check if length is odd
                if ((j - i + 1) % 2 == 1) {
                    for (int k = i; k <= j; k++) {
                        total += arr[k];
                    }
                }

            }
        }

        return total;
    }
}
