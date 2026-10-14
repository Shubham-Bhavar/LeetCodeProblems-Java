
/*
 * LeetCode 3016: Minimum Number of Pushes to Type Word II
 *
 * Problem:
 * Remap the 8 keys (2 to 9) to minimize the total
 * number of pushes required to type the given word.
 *
 * Approach: Greedy
 * 1. Count the frequency of every character.
 * 2. Sort frequencies in descending order.
 * 3. The 8 most frequent letters need 1 push each.
 * 4. The next 8 need 2 pushes each, and so on.
 *
 * Time Complexity: O(n + 26 log 26)
 * Space Complexity: O(26) = O(1)
 */

import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        // Count frequency of each letter
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort frequencies in ascending order
        Arrays.sort(freq);

        int totalPushes = 0;

        // Process from highest frequency to lowest
        for (int i = 25; i >= 0; i--) {
            int rank = 25 - i;
            int pushes = rank / 8 + 1;

            totalPushes += freq[i] * pushes;
        }

        return totalPushes;
    }
}
