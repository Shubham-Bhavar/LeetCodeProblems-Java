/*
PROBLEM: Minimum Operations to Make Array Equal

Understanding:
arr = [1, 3, 5, 7, ...]
This is an arithmetic sequence of odd numbers.

Goal:
Make all elements equal with minimum operations.

Important Observation:
- Each operation moves 1 unit from one element to another
- Final value must be the median (middle value)

Example:
n = 3 → [1,3,5]
Target = 3
Operations:
(5 → 3) needs 2 moves → total = 2

n = 6 → [1,3,5,7,9,11]
Target = 6
Moves needed:
(1→6)=5, (3→6)=3, (5→6)=1 → total = 9

Pattern:
- We only calculate moves for half elements

Formula Derivation:
Let m = n/2

If n is even:
operations = m * m

If n is odd:
operations = m * (m + 1)

Optimized Combined Formula:
operations = (n/2) * ((n+1)/2)

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int minOperations(int n) {
        return (n / 2) * ((n + 1) / 2);
    }
}
