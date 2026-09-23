/*
    LeetCode 49 - Group Anagrams

    Problem:
    --------
    Given an array of strings strs, group the anagrams together.
    You can return the answer in any order.

    Anagrams are strings that contain the same characters with
    the same frequencies, but possibly in a different order.

    Example 1:
    Input:
    strs = ["eat","tea","tan","ate","nat","bat"]

    Output:
    [["bat"],["nat","tan"],["ate","eat","tea"]]

    Example 2:
    Input:
    strs = [""]

    Output:
    [[""]]

    Example 3:
    Input:
    strs = ["a"]

    Output:
    [["a"]]

    Approach:
    ---------
    1. Use a HashMap.
    2. Sort each string alphabetically.
    3. Use the sorted string as the key.
    4. Anagrams will have the same sorted key.
    5. Add each original string to the list for that key.
    6. Return all values from the HashMap.

    Example:
    "eat" -> "aet"
    "tea" -> "aet"
    "ate" -> "aet"

    Therefore:
    "aet" -> ["eat", "tea", "ate"]

    Time Complexity:
    O(n * k log k)

    Space Complexity:
    O(n * k)

    Where:
    n = number of strings
    k = maximum length of a string
*/
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        Map<String, List<String>> map = new HashMap<>();

        for (String sts : strs)
        {
            char[] ch = sts.toCharArray();
            Arrays.sort(ch);

            String key = new String(ch);

            if (!map.containsKey(key))
            {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(sts);
        }

        return new ArrayList<>(map.values());
    }
}
