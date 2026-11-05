
/*
 * Find All Valid Binary Strings of Length N
 *
 * Approach: Backtracking
 *
 * Time Complexity: O(2^n * n)
 * Space Complexity: O(n) auxiliary space
 * Excluding the output list.
 */

import java.util.*;

class Solution {
    public List<String> validStrings(int n, int k) {
        List<String> result = new ArrayList<>();
        generate(n, k, 0, 0, false, new StringBuilder(), result);
        return result;
    }

    private void generate(int n, int k, int index, int cost,
                          boolean prevOne, StringBuilder sb,
                          List<String> result) {

        if (index == n) {
            result.add(sb.toString());
            return;
        }

        // Add 0
        sb.append('0');
        generate(n, k, index + 1, cost, false, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        // Add 1 if previous character is not 1 and cost is within k
        if (!prevOne && cost + index <= k) {
            sb.append('1');
            generate(n, k, index + 1, cost + index, true, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
