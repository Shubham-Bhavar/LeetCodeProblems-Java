/*
Question:
Check if knight can reach target in EVEN moves.

Logic:
If start and target have same color → TRUE
Else → FALSE

Name: Shubham Bhavar
*/

import java.util.*;

public class Main {

    public static boolean isEvenMoves(int[] start, int[] target) {

        int startColor = (start[0] + start[1]) % 2;
        int targetColor = (target[0] + target[1]) % 2;

        return startColor == targetColor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] start = new int[2];
        int[] target = new int[2];

        System.out.print("Enter start (x y): ");
        start[0] = sc.nextInt();
        start[1] = sc.nextInt();

        System.out.print("Enter target (x y): ");
        target[0] = sc.nextInt();
        target[1] = sc.nextInt();

        System.out.println("Result: " + isEvenMoves(start, target));

        sc.close();
    }
}
