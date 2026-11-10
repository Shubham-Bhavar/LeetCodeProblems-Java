
/*
 * LeetCode 1096. Brace Expansion II
 *
 * Problem:
 * Expand the expression and return all distinct
 * words in lexicographical order.
 *
 * Approach: Recursion + HashSet + Cartesian Product
 *
 * Time Complexity: Depends on the number of generated words.
 * Space Complexity: O(K), where K is the number of intermediate words.
 */

import java.util.*;

class Solution {

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, new int[]{0});

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }

    private Set<String> parse(String s, int[] index) {

        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();

        current.add("");

        while (index[0] < s.length() &&
               s.charAt(index[0]) != '}') {

            char ch = s.charAt(index[0]);

            if (ch == ',') {
                result.addAll(current);
                current.clear();
                current.add("");
                index[0]++;
            }
            else {
                Set<String> next;

                if (ch == '{') {
                    index[0]++;
                    next = parse(s, index);
                    index[0]++;
                }
                else {
                    next = new HashSet<>();
                    next.add(String.valueOf(ch));
                    index[0]++;
                }

                current = combine(current, next);
            }
        }

        result.addAll(current);

        return result;
    }

    private Set<String> combine(Set<String> first,
                                Set<String> second) {

        Set<String> result = new HashSet<>();

        for (String a : first) {
            for (String b : second) {
                result.add(a + b);
            }
        }

        return result;
    }
}
