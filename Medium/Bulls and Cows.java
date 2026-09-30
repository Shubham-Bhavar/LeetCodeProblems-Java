/*
 * ============================================================
 * LeetCode 299: Bulls and Cows
 * ============================================================
 *
 * Problem:
 * ------------------------------------------------------------
 * Given two strings secret and guess:
 *
 * - A "bull" is a digit that is in the correct position.
 * - A "cow" is a digit that exists in secret but is in the
 *   wrong position.
 *
 * Return the hint in the format:
 *
 *     "xAyB"
 *
 * where:
 *     x = number of bulls
 *     y = number of cows
 *
 * Duplicate digits are possible.
 *
 * ------------------------------------------------------------
 * Example 1:
 * ------------------------------------------------------------
 *
 * Input:
 * secret = "1807"
 * guess  = "7810"
 *
 * Output:
 * "1A3B"
 *
 * ------------------------------------------------------------
 * Example 2:
 * ------------------------------------------------------------
 *
 * Input:
 * secret = "1123"
 * guess  = "0111"
 *
 * Output:
 * "1A1B"
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * Step 1:
 * Find bulls.
 *
 * If secret[i] == guess[i], it is a bull.
 *
 * Step 2:
 * For non-bull digits, count their frequencies.
 *
 * For every digit, the number of cows is:
 *
 *     min(secretFrequency, guessFrequency)
 *
 * This automatically handles duplicate digits correctly.
 *
 * ------------------------------------------------------------
 * Complexity:
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 *
 * We only use arrays of size 10 because there are
 * only 10 possible digits (0 to 9).
 *
 * ============================================================
 */

class Solution {

    public String getHint(String secret, String guess) {

        int bulls = 0;

        // Frequency of non-bull digits in secret
        int[] secretCount = new int[10];

        // Frequency of non-bull digits in guess
        int[] guessCount = new int[10];

        // Step 1: Find bulls
        for (int i = 0; i < secret.length(); i++) {

            if (secret.charAt(i) == guess.charAt(i)) {

                bulls++;

            } else {

                // Store only non-bull digits
                secretCount[secret.charAt(i) - '0']++;
                guessCount[guess.charAt(i) - '0']++;
            }
        }

        // Step 2: Find cows
        int cows = 0;

        for (int digit = 0; digit <= 9; digit++) {

            cows += Math.min(
                secretCount[digit],
                guessCount[digit]
            );
        }

        return bulls + "A" + cows + "B";
    }
}
