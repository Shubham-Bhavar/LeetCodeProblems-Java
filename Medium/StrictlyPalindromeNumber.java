/*
Question:
Check if integer n is strictly palindromic.
A number is strictly palindromic if for every base b (2 to n-2),
its representation is palindrome.

Insight:
For all n >= 4 → ALWAYS false

Name: Shubham Bhavar
*/

import java.util.*;

public class Main {

    public static boolean isStrictlyPalindromic(int n) {
        return false; // proven mathematically
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Result: " + isStrictlyPalindromic(n));

        sc.close();
    }
}
