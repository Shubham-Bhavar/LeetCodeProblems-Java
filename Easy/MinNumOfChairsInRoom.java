// Problem (Simple):
// Given a string with 'E' (enter) and 'L' (leave),
// find minimum chairs needed so no one stands.

import java.util.*;

class Solution {
    public static int minimumChairs(String s) {
        int current = 0;   // current people in room
        int maxChairs = 0; // maximum needed

        for (char ch : s.toCharArray()) {
            if (ch == 'E') {
                current++;
                if (current > maxChairs) {
                    maxChairs = current;
                }
            } else {
                current--;
            }
        }
        return maxChairs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println("Minimum Chairs Required: " + minimumChairs(s));
    }
}
