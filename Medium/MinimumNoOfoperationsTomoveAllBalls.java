/*
Q) You have n boxes. You are given a binary string boxes of length n, 
where boxes[i] is '0' if empty and '1' if it contains a ball.

In one operation, you can move one ball to an adjacent box.

Return an array where answer[i] is minimum operations 
to move all balls to ith box.
*/

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int moves = 0;

            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    moves += Math.abs(i - j);
                }
            }

            ans[i] = moves;
        }

        return ans;
    }
}
