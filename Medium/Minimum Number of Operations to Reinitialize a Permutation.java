/*
============================================================
LEETCODE 1806: Minimum Number of Operations to Reinitialize
a Permutation
============================================================

PROBLEM:
You are given an even integer n.

Initially:
perm[i] = i

After each operation, the elements are rearranged according
to the given rules.

Return the minimum non-zero number of operations needed to
return the permutation back to its initial state.

============================================================
EXAMPLE:

n = 4

Initial:
[0, 1, 2, 3]

After 1 operation:
[0, 2, 1, 3]

After 2 operations:
[0, 1, 2, 3]

Answer = 2

============================================================
OPTIMIZED APPROACH:

We do not need to create the entire permutation.

We only track the position of index 1.

After each operation:

If index is even:
index = index / 2

If index is odd:
index = n / 2 + (index - 1) / 2

When index becomes 1 again, the permutation returns to
its initial state.

============================================================
TIME COMPLEXITY:
O(k), where k is the number of operations

SPACE COMPLEXITY:
O(1)

============================================================
*/

class Solution {
    public int reinitializePermutation(int n) {
        int count = 0;
        int index = 1;

        do {
            if (index % 2 == 0) {
                index = index / 2;
            } else {
                index = n / 2 + (index - 1) / 2;
            }

            count++;

        } while (index != 1);

        return count;
    }
}
