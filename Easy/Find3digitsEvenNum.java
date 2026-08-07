/*
Q) Find all unique 3-digit EVEN numbers (no leading zero)

Logic:
- Try all i, j, k
- i != j != k
- first digit != 0
- last digit even
- use TreeSet

Time: O(n^3)
*/

import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] d) {
        Set<Integer> set = new TreeSet<>();
        int n = d.length;

        for (int i = 0; i < n; i++) {
            if (d[i] == 0) continue;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j || d[k] % 2 != 0) continue;

                    set.add(d[i]*100 + d[j]*10 + d[k]);
                }
            }
        }

        int[] res = new int[set.size()];
        int idx = 0;
        for (int x : set) res[idx++] = x;
        return res;
    }
}
