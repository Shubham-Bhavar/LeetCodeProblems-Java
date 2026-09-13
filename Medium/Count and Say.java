```java
/*
========================================================
LeetCode 38 - Count and Say
========================================================

Problem:
--------
The Count-and-Say sequence is a sequence of digit strings.

countAndSay(1) = "1"

For every next term, describe the previous term by
counting consecutive identical digits.

Example:
"1"      -> "11"       (one 1)
"11"     -> "21"       (two 1s)
"21"     -> "1211"     (one 2, one 1)
"1211"   -> "111221"   (one 1, one 2, two 1s)

Given n, return the nth element of the sequence.

========================================================
Example:
========================================================

Input:
n = 4

Output:
"1211"

========================================================
Approach:
========================================================

1. Start with "1".
2. Repeat until we reach n.
3. Count consecutive same digits.
4. When the digit changes, add:
   count + digit
5. Add the last group after the loop.
6. Store the new string and continue.

========================================================
Complexity:
========================================================

Time:  O(n * L)
Space: O(L)

L = length of the current string.

========================================================
*/

class Solution {

    public String countAndSay(int n) {

        String s = "1";

        while (n > 1) {

            String temp = "";
            int count = 1;

            for (int i = 1; i < s.length(); i++) {

                if (s.charAt(i) == s.charAt(i - 1)) {
                    count++;
                } 
                else {
                    temp += count;
                    temp += s.charAt(i - 1);
                    count = 1;
                }
            }

            // Add the last group
            temp += count;
            temp += s.charAt(s.length() - 1);

            s = temp;
            n--;
        }

        return s;
    }
}
```
