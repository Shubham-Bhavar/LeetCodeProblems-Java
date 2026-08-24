    /*
     * Question:
     * Find the key by taking the smallest digit
     * at each corresponding position of num1, num2, and num3.
     *
     * Numbers with fewer than 4 digits are treated
     * as having leading zeros.
     */
class Solution {
  
    public int generateKey(int num1, int num2, int num3) {

        int key = 0;
        int place = 1;

        // Check all 4 digit positions
        for (int i = 0; i < 4; i++) {

            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
            int digit3 = num3 % 10;

            // Find the smallest digit at this position
            int minDigit = Math.min(
                digit1,
                Math.min(digit2, digit3)
            );

            // Build the key
            key += minDigit * place;

            // Move to the next digit
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;

            place *= 10;
        }

        return key;
    }
}
