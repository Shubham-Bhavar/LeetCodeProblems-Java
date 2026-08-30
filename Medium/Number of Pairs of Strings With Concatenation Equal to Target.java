```java
/*
LeetCode: Number of Pairs of Strings With Concatenation Equal to Target

Problem:
Find the number of pairs (i, j), where i != j,
such that nums[i] + nums[j] == target.

Approach:
1. Try every pair of strings.
2. Concatenate nums[i] and nums[j].
3. If the result equals target, increase the count.
4. Return the count.

Time Complexity: O(n^2 * m)
Space Complexity: O(1)

where:
n = number of strings
m = maximum length of a string
*/

class Solution {
    public int numOfPairs(String[] nums, String target) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                // i and j must be different
                if (i != j) {

                    // Check concatenation
                    if ((nums[i] + nums[j]).equals(target)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
```
