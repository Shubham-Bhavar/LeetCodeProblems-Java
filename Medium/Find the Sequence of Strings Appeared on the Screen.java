/*
LeetCode 3324: Find the Sequence of Strings Appeared on the Screen
Difficulty: Easy
Topics: String, Simulation

Approach:
1. Start with an empty string.
2. For each target character, append 'a' and then change it
   character by character until it matches the target character.
3. Store every string that appears on the screen.

Time Complexity: O(n * 26)
Space Complexity: O(n * 26)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();
        StringBuilder screen = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {
            screen.append('a');
            result.add(screen.toString());

            while (screen.charAt(i) != target.charAt(i)) {
                screen.setCharAt(i, (char) (screen.charAt(i) + 1));
                result.add(screen.toString());
            }
        }

        return result;
    }
}
