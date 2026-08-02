/*
Question:
Given an array of strings (same length),
count how many columns are NOT sorted lexicographically.

A column is sorted if:
strs[i][j] <= strs[i+1][j] for all i

Example:
Input: ["cba","daf","ghi"]
Output: 1

Name: Shubham Bhavar
*/

import java.util.*;

public class Main {

    public static int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int count = 0;

        // Check each column
        for (int j = 0; j < m; j++) {

            for (int i = 0; i < n - 1; i++) {

                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    count++; // column not sorted
                    break;   // move to next column
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Enter number of strings: ");
        n = sc.nextInt();

        String[] strs = new String[n];

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }

        System.out.println("Result: " + minDeletionSize(strs));

        sc.close();
    }
}
