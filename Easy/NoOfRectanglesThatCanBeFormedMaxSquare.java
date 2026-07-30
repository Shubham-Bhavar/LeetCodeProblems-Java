/*
Question:
You are given an array rectangles where rectangles[i] = [li, wi]
represents the ith rectangle of length li and width wi.

You can cut a rectangle to form a square of side k if:
k <= li and k <= wi

maxLen = largest possible square side from all rectangles.

Return the number of rectangles that can form a square of side maxLen.

Example 1:
Input: [[5,8],[3,9],[5,12],[16,5]]
Output: 3

Example 2:
Input: [[2,3],[3,7],[4,3],[3,7]]
Output: 3
*/

public class CountGoodRectangles {

    public static int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int count = 0;

        for (int[] rect : rectangles) {
            int side = Math.min(rect[0], rect[1]); // max square from this rectangle

            if (side > maxLen) {
                maxLen = side;
                count = 1; // new max found
            } else if (side == maxLen) {
                count++; // same max
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] rectangles1 = {{5,8},{3,9},{5,12},{16,5}};
        System.out.println(countGoodRectangles(rectangles1)); // 3

        int[][] rectangles2 = {{2,3},{3,7},{4,3},{3,7}};
        System.out.println(countGoodRectangles(rectangles2)); // 3
    }
}
