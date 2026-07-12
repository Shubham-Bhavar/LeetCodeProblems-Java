/*
Question:
Three people at positions x, y, z.
Person 1 and 2 move toward Person 3 with same speed.
Find who reaches first.

Approach:
Compare distance from x → z and y → z
*/

class Solution {
    public int findClosest(int x, int y, int z) {
        int d1 = Math.abs(x - z); // distance of Person 1
        int d2 = Math.abs(y - z); // distance of Person 2

        if (d1 < d2) return 1;  // Person 1 closer
        else if (d2 < d1) return 2; // Person 2 closer
        else return 0; // both same distance
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println(obj.findClosest(2,7,4)); // 1
        System.out.println(obj.findClosest(2,5,6)); // 2
        System.out.println(obj.findClosest(1,5,3)); // 0
    }
}
