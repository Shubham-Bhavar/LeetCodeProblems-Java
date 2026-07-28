// Problem (Simple):
// Given an array and number k,
// add only those elements whose frequency is divisible by k.

import java.util.*;

class Solution {
    public static int sumOfElements(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // count frequency
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int sum = 0;

        // calculate sum
        for (int num : freq.keySet()) {
            int count = freq.get(num);

            if (count % k == 0) {
                sum += num * count; // include all occurrences
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3,3,4};
        int k = 2;

        System.out.println("Sum: " + sumOfElements(nums, k));
    }
}
