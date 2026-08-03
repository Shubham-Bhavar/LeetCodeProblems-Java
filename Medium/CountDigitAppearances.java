/*
Question:
Count total occurrences of a digit in all numbers of array.

Example:
Input: nums = [12,54,32,22], digit = 2
Output: 4

Name: Shubham Bhavar
*/

import java.util.*;

public class Main {

    public static int countDigit(int[] nums, int digit) {
        int count = 0;

        for (int num : nums) {

            while (num > 0) {
                if (num % 10 == digit) {
                    count++;
                }
                num /= 10;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter digit: ");
        int digit = sc.nextInt();

        System.out.println("Result: " + countDigit(nums, digit));

        sc.close();
    }
}
