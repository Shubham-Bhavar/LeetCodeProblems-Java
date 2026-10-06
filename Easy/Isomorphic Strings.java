/*
 * LeetCode 205: Isomorphic Strings
 *
 * Problem:
 * Given two strings s and t, determine whether they are isomorphic.
 *
 * Two strings are isomorphic if characters in s can be replaced
 * to get t while preserving the order.
 *
 * Rules:
 * - One character must always map to the same character.
 * - Two different characters cannot map to the same character.
 *
 * Example 1:
 * Input:  s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 * Input:  s = "f11", t = "b23"
 * Output: false
 *
 * Example 3:
 * Input:  s = "paper", t = "title"
 * Output: true
 *
 * Approach:
 * Use two arrays to store the mapping in both directions.
 *
 * mapST -> character from s mapped to character in t
 * mapTS -> character from t mapped to character in s
 *
 * We need both directions because two different characters
 * from s cannot map to the same character in t.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * (ASCII characters = fixed size 128)
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {

        int[] mapST = new int[128];
        int[] mapTS = new int[128];

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            // Check existing mappings
            if (mapST[a] != 0 && mapST[a] != b) {
                return false;
            }

            if (mapTS[b] != 0 && mapTS[b] != a) {
                return false;
            }

            // Create mapping
            mapST[a] = b;
            mapTS[b] = a;
        }

        return true;
    }
}
