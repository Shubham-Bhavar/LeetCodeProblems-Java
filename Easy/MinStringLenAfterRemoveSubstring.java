/*
Question:
Remove substrings "AB" and "CD" repeatedly
and return minimum possible length.

Example:
Input: "ABFCACDB"
Output: 2

Name: Shubham Bhavar
*/

import java.util.*;

public class Main {

    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!stack.isEmpty()) {
                char top = stack.peek();

                // check for AB or CD
                if ((top == 'A' && ch == 'B') ||
                    (top == 'C' && ch == 'D')) {
                    stack.pop(); // remove pair
                    continue;
                }
            }

            stack.push(ch);
        }

        return stack.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.next();

        System.out.println("Result: " + minLength(s));

        sc.close();
    }
}
