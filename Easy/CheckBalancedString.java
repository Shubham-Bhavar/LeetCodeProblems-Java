/*
Question:
Given a string 'num' containing digits, check if it is balanced.
A string is balanced if the sum of digits at even indices
is equal to the sum of digits at odd indices.
Return true if balanced, otherwise false.
*/

public class Main {
    public static boolean isBalanced(String num) {
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';

            if (i % 2 == 0) {
                evenSum += digit;
            } else {
                oddSum += digit;
            }
        }

        return evenSum == oddSum;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("1234"));  // false
        System.out.println(isBalanced("24123")); // true
    }
}
