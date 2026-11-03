
/*
 * LeetCode 537 - Complex Number Multiplication
 *
 * Difficulty: Medium
 * Approach: String Parsing + Math
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] a = num1.replace("i", "").split("\\+");
        String[] b = num2.replace("i", "").split("\\+");

        int real1 = Integer.parseInt(a[0]);
        int imag1 = Integer.parseInt(a[1]);

        int real2 = Integer.parseInt(b[0]);
        int imag2 = Integer.parseInt(b[1]);

        // Complex number multiplication
        int real = real1 * real2 - imag1 * imag2;
        int imag = real1 * imag2 + imag1 * real2;

        return real + "+" + imag + "i";
    }
}
