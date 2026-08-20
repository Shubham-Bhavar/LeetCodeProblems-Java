/*
Question: Minimum Length After Removing Equal 'a' and 'b' Substrings

You can remove any substring containing an equal number of 'a' and 'b'.

To get the minimum possible length:
- Every 'a' can cancel with one 'b'.
- Therefore, remove min(countA, countB) pairs.

Minimum length = |countA - countB|

Example:
"aabbab"
a = 3, b = 3
Answer = |3 - 3| = 0

"aaabb"
a = 3, b = 2
Answer = |3 - 2| = 1
*/

class Solution {

    public int minimumLength(String s) {
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                count++;
            } else {
                count--;
            }
        }

        return Math.abs(count);
    }
}
