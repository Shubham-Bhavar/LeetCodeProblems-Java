/*
Question:
For each character:
1) Find reversed alphabet position → ('a'=26, 'b'=25, ..., 'z'=1)
2) Multiply with its 1-based index
3) Sum all values
*/

class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int reversePos = 'z' - ch + 1; // reversed alphabet position
            int index = i + 1; // 1-based index

            sum += reversePos * index;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println(obj.reverseDegree("abc"));  // 148
        System.out.println(obj.reverseDegree("zaza")); // 160
    }
}
