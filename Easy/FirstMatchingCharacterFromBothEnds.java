/*
Question:
Given a string s, find the smallest index i such that:
s[i] == s[n - i - 1]
If no such index exists, return -1.
*/

class Solution {
    public int findIndex(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt(n - i - 1)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println(obj.findIndex("abcacbd")); // 1
        System.out.println(obj.findIndex("abc"));     // 1
        System.out.println(obj.findIndex("abcdab"));  // -1
    }
}
