
/*
 * Problem: 2517. Maximum Tastiness of Candy Basket
 * Difficulty: Medium
 * Approach: Sorting + Binary Search + Greedy
 * Time Complexity: O(n log n + n log(maxPrice))
 * Space Complexity: O(1) auxiliary space
 */

import java.util.*;

class Solution {

    public int maximumTastiness(int[] price, int k) {

        Arrays.sort(price);

        int low = 0;
        int high = price[price.length - 1] - price[0];

        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canSelect(price, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private boolean canSelect(int[] price, int k, int minDiff) {

        int count = 1;
        int lastPrice = price[0];

        for (int i = 1; i < price.length; i++) {

            if (price[i] - lastPrice >= minDiff) {
                count++;
                lastPrice = price[i];
            }

            if (count >= k) {
                return true;
            }
        }

        return false;
    }
}
