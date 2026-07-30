/*
Question:
You are given two non-negative integers num1 and num2.

In one operation:
- If num1 >= num2 → subtract num2 from num1
- Else → subtract num1 from num2

Return the number of operations required to make either num1 = 0 or num2 = 0.

Example 1:
Input: num1 = 2, num2 = 3
Output: 3

Example 2:
Input: num1 = 10, num2 = 10
Output: 1
*/

public class CountOperations {

    public static int countOperations(int num1, int num2) {
        int count = 0;

        // Repeat until one becomes 0
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOperations(2, 3));   // Output: 3
        System.out.println(countOperations(10, 10)); // Output: 1
    }
}
