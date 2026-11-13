
/*
 * LeetCode 1122: Relative Sort Array
 *
 * Problem:
 * Sort arr1 according to the order of elements in arr2.
 * Remaining elements must be placed at the end
 * in ascending order.
 *
 * Approach:
 * Frequency Array (Counting Sort)
 *
 * Step-by-step Explanation:
 * 1. Create a frequency array of size 1001.
 * 2. Count the occurrences of every element in arr1.
 * 3. Traverse arr2 and add each element according
 *    to its frequency.
 * 4. Traverse the frequency array from 0 to 1000.
 * 5. Add all remaining elements in ascending order.
 * 6. Return the result array.
 *
 * Time Complexity: O(n + m + 1000)
 * Space Complexity: O(1000)
 */

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] freq = new int[1001];

        // Count frequency of elements in arr1.
        for (int num : arr1) {
            freq[num]++;
        }

        int index = 0;

        // Add elements according to arr2 order.
        for (int num : arr2) {

            while (freq[num] > 0) {
                arr1[index++] = num;
                freq[num]--;
            }
        }

        // Add remaining elements in ascending order.
        for (int i = 0; i <= 1000; i++) {

            while (freq[i] > 0) {
                arr1[index++] = i;
                freq[i]--;
            }
        }

        return arr1;
    }
}
