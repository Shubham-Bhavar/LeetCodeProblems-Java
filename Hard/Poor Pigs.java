
/*
 * LeetCode 458: Poor Pigs
 *
 * Problem:
 * We are given:
 * - buckets: Total number of buckets.
 * - minutesToDie: Time taken for a pig to die after drinking poison.
 * - minutesToTest: Total available testing time.
 *
 * Find the minimum number of pigs needed to identify
 * the poisonous bucket.
 *
 * Approach:
 * Mathematical Calculation.
 *
 * Step-by-Step Explanation:
 * 1. Calculate the number of testing rounds:
 *      rounds = minutesToTest / minutesToDie
 *
 * 2. Each pig has (rounds + 1) possible states:
 *      - Dies in round 1
 *      - Dies in round 2
 *      - ...
 *      - Dies in the last round
 *      - Survives all rounds
 *
 * 3. If we have p pigs, the total number of buckets
 *    we can identify is:
 *
 *      (rounds + 1) ^ p
 *
 * 4. Find the minimum p such that:
 *
 *      (rounds + 1) ^ p >= buckets
 *
 * Time Complexity: O(log(buckets))
 * Space Complexity: O(1)
 */

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        // Calculate the number of testing rounds
        int rounds = minutesToTest / minutesToDie;

        // Possible states for each pig
        int states = rounds + 1;

        int pigs = 0;
        long capacity = 1;

        // Find minimum pigs needed
        while (capacity < buckets) {

            capacity *= states;
            pigs++;
        }

        return pigs;
    }
}
