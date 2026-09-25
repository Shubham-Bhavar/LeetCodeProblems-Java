/*
    LeetCode 204 - Count Primes

    Problem:
    --------
    Given an integer n, return the number of prime numbers
    that are strictly less than n.

    Example 1:
    Input:
    n = 10

    Output:
    4

    Explanation:
    Prime numbers less than 10 are:
    2, 3, 5, 7

    Example 2:
    Input:
    n = 0

    Output:
    0

    Example 3:
    Input:
    n = 1

    Output:
    0

    Approach:
    ---------
    Use the Sieve of Eratosthenes.

    1. Create a boolean array where true means the number
       is currently considered prime.
    2. Start from 2.
    3. If the number is prime, mark all its multiples as
       non-prime.
    4. Count the remaining prime numbers.

    We start marking from i * i because smaller multiples
    have already been marked by smaller prime numbers.

    Time Complexity: O(n log log n)
    Space Complexity: O(n)
*/

class Solution {
    public int countPrimes(int n) 
    {
        if (n <= 2)
        {
            return 0;
        }

        boolean[] isPrime = new boolean[n];

        // Assume every number is prime initially
        for (int i = 2; i < n; i++)
        {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++)
        {
            if (isPrime[i])
            {
                for (int j = i * i; j < n; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }

        // Count prime numbers
        int count = 0;

        for (int i = 2; i < n; i++)
        {
            if (isPrime[i])
            {
                count++;
            }
        }

        return count;
    }
}
