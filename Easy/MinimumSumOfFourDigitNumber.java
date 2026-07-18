    /*
    ❓ Goal: Split digits into 2 numbers with minimum sum
    ❓ Trick: Sort digits → distribute alternately
    ❓ Why: Keeps numbers small → minimum sum
    */
import java.util.*;

class Solution {

    public int minimumSum(int num) {

        // Convert number to char array
        char[] digits = String.valueOf(num).toCharArray();

        // Sort digits
        Arrays.sort(digits);

        // Form two numbers
        int new1 = (digits[0] - '0') * 10 + (digits[2] - '0');
        int new2 = (digits[1] - '0') * 10 + (digits[3] - '0');

        return new1 + new2;
    }
}
