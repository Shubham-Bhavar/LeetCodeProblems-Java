/*
============================================================
LEETCODE: First Letter to Appear Twice
============================================================

PROBLEM:
Given a string s containing lowercase English letters,
return the first letter that appears twice.

A letter is considered first if its second occurrence
appears before the second occurrence of any other letter.

============================================================
EXAMPLE:

Input:
s = "abccbaacz"

PROCESS:

| Index | Letter | Already Seen? | Result |
|-------|--------|---------------|--------|
| 0     | a      | No            | Store a |
| 1     | b      | No            | Store b |
| 2     | c      | No            | Store c |
| 3     | c      | Yes           | Return c |

Output:
c

============================================================
APPROACH:

1. Create a boolean array to track the 26 lowercase letters.
2. Traverse the string from left to right.
3. If the current letter was already seen, return it.
4. Otherwise, mark the letter as seen.

============================================================
TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1)

============================================================
*/

class Solution {
    public char repeatedCharacter(String s) {
        boolean[] seen = new boolean[26];

        for (char ch : s.toCharArray()) {
            int index = ch - 'a';

            // If character already appeared, return it
            if (seen[index]) {
                return ch;
            }

            // Mark current character as seen
            seen[index] = true;
        }

        return ' ';
    }
}
