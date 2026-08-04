/*
LeetCode 2149:
Rearrange Array Elements by Sign

Conditions:
1. Alternate signs (+, -)
2. Maintain relative order
3. Start with positive
*/

import java.util.*;

public class Main {

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Separate positives and negatives
        for (int num : nums) {
            if (num > 0) pos.add(num);
            else neg.add(num);
        }

        int[] result = new int[n];
        int i = 0, j = 0;

        // Fill alternately
        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                result[k] = pos.get(i++);
            } else {
                result[k] = neg.get(j++);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};

        int[] result = rearrangeArray(nums);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
