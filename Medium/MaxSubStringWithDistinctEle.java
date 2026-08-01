/*
Question:
Given string s, split into maximum substrings such that
each substring starts with a unique character.

Return maximum number of such substrings.
*/

import java.util.*;

class Solution {
    public int maxSubstrings(String s) {
        Set<Character> set = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        
        return set.size();
    }
}
