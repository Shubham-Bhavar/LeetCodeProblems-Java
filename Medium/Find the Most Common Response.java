
/*
 * LeetCode 3527: Find the Most Common Response
 *
 * Approach: HashMap + HashSet
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */

import java.util.*;

class Solution {
    public String findCommonResponse(List<List<String>> responses) {

        Map<String, Integer> frequency = new HashMap<>();

        // Count each response only once per day.
        for (List<String> day : responses) {

            Set<String> unique = new HashSet<>(day);

            for (String response : unique) {
                frequency.put(
                    response,
                    frequency.getOrDefault(response, 0) + 1
                );
            }
        }

        String result = "";
        int maxCount = 0;

        // Find the most frequent response.
        for (String response : frequency.keySet()) {

            int count = frequency.get(response);

            if (count > maxCount ||
                (count == maxCount && response.compareTo(result) < 0)) {

                maxCount = count;
                result = response;
            }
        }

        return result;
    }
}
