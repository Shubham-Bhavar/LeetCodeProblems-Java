/*
Q: Find indices of words that contain character 'x'
*/

import java.util.*;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> result = new ArrayList<>();   // to store indices

        for (int i = 0; i < words.length; i++) {

            // check: does current word contain x?
            if (words[i].indexOf(x) != -1) {
                result.add(i);                     // store index
            }
        }

        return result;                             // final indices
    }
}
