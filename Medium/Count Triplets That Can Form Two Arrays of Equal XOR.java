```java
/*
LeetCode 1442 - Count Triplets That Can Form Two Arrays of Equal XOR

Problem:
Given an array arr, choose indices i, j and k such that:

0 <= i < j <= k < arr.length

a = arr[i] ^ arr[i+1] ^ ... ^ arr[j-1]
b = arr[j] ^ arr[j+1] ^ ... ^ arr[k]

Count the number of triplets where a == b.

Example:
Input:  arr = [2,3,1,6,7]
Output: 4


Key XOR Property:
If

a ^ b = 0

then

a == b

Because:

x ^ x = 0


Approach:
1. Use prefix XOR.
2. Try every possible i and k.
3. If XOR from i to k is 0, then every possible j
   between i+1 and k creates a valid triplet.
4. Therefore, add (k - i) to the answer.

Why?
If:

arr[i] ^ ... ^ arr[k] = 0

then:

(arr[i] ^ ... ^ arr[j-1])
==
(arr[j] ^ ... ^ arr[k])

for every j between i+1 and k.


Time Complexity: O(n^2)
Space Complexity: O(1)
*/

class Solution {
    public int countTriplets(int[] arr) {

        int count = 0;

        for(int i = 0; i < arr.length; i++)
        {
            int xor = 0;

            for(int k = i; k < arr.length; k++)
            {
                xor ^= arr[k];

                // Total XOR from i to k is zero
                if(xor == 0)
                {
                    // Every j from i+1 to k is valid
                    count += k - i;
                }
            }
        }

        return count;
    }
}
```
