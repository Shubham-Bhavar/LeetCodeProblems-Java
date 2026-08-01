/*
Question:
A square triple (a, b, c) satisfies:
a^2 + b^2 = c^2

Given n, count all triples where:
1 <= a, b, c <= n

Example:
Input: n = 5
Output: 2

Name: Shubham Bhavar
*/

import java.util.*;

public class Main {

    public static int countSquareTriples(int n) {
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {

                int sum = a * a + b * b;
                int c = (int) Math.sqrt(sum);

                // Check perfect square and limit
                if (c * c == sum && c <= n) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Result: " + countSquareTriples(n));

        sc.close();
    }
}
