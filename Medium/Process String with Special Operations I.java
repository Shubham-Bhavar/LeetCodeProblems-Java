```java
/**
 * LeetCode 3612: Process String with Special Operations I
 *
 * Approach:
 * Process the string from left to right.
 * - Lowercase letter: Append it to the result.
 * - '*': Remove the last character if it exists.
 * - '#': Duplicate the current result.
 * - '%': Reverse the current result.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */

class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                result.append(ch);
            } else if (ch == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (ch == '#') {
                String current = result.toString();
                result.append(current);
            } else if (ch == '%') {
                result.reverse();
            }
        }

        return result.toString();
    }
}
```
