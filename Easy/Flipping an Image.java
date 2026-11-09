
/*
 * LeetCode 832: Flipping an Image
 *
 * Approach: Two Pointers + Bitwise XOR
 * Time Complexity: O(n * n)
 * Space Complexity: O(1) auxiliary space
 */

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        int n = image.length;

        for (int[] row : image) {

            int left = 0;
            int right = n - 1;

            while (left <= right) {

                // Swap and invert both elements.
                int temp = row[left] ^ 1;
                row[left] = row[right] ^ 1;
                row[right] = temp;

                left++;
                right--;
            }
        }

        return image;
    }
}
