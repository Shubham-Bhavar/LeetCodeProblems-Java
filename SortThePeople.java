/*
Question:
Given two arrays:
names[i] → person's name
heights[i] → person's height (distinct)

Return names sorted in descending order of heights.
*/

import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        // create index array
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        // sort indices based on heights (descending)
        Arrays.sort(index, (a, b) -> heights[b] - heights[a]);

        // build result using sorted indices
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = names[index[i]];
        }

        return result;
    }
}
