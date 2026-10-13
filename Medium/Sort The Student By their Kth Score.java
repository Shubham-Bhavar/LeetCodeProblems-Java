/*
 * LeetCode 2545: Sort the Students by Their Kth Score
 *
 * Problem:
 * Given a 2D array score, where score[i][j] is the score
 * of the ith student in the jth exam, sort the students
 * in descending order according to the kth exam score.
 *
 * Example:
 * Input:
 * score = [[10,6,9,1],
 *          [7,5,11,2],
 *          [4,8,3,15]]
 * k = 2
 *
 * Output:
 * [[7,5,11,2],
 *  [10,6,9,1],
 *  [4,8,3,15]]
 *
 * Approach:
 * Sort rows by score[i][k] in descending order.
 *
 * Time Complexity: O(m log m)
 * Space Complexity: O(log m) auxiliary space (typical sorting)
 */

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score;
    }
}