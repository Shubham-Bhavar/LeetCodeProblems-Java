/*
Q) Given two strings jewels and stones.
   jewels represents types of stones that are jewels.
   stones represents stones you have.

   Return how many stones are also jewels.

Note:
- Case sensitive ('a' != 'A')
- jewels characters are unique

Approach:
Use HashSet for fast lookup
*/

import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();

        // Store all jewels
        for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }

        int count = 0;

        // Count matching stones
        for (char ch : stones.toCharArray()) {
            if (set.contains(ch)) {
                count++;
            }
        }

        return count;
    }
}
