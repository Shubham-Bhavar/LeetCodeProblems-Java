/*Given an integer n, return a string array where:

If number is divisible by 3 → "Fizz"
If number is divisible by 5 → "Buzz"
If number is divisible by both 3 and 5 → "FizzBuzz"
Otherwise → number itself*/
import java.util.*;

class Solution {
    public List<String> fizzBuzz(int n) {

        // Store answer
        List<String> result = new ArrayList<>();

        // Traverse from 1 to n
        for (int i = 1; i <= n; i++) {

            // Divisible by both 3 and 5
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            }

            // Divisible by 3
            else if (i % 3 == 0) {
                result.add("Fizz");
            }

            // Divisible by 5
            else if (i % 5 == 0) {
                result.add("Buzz");
            }

            // Otherwise add the number
            else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}
