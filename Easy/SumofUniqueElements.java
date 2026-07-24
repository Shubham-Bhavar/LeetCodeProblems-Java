/*You are given an integer array nums. 
The unique elements of an array are the elements that appear exactly once in the array. 
Return the sum of all the unique elements of nums.*/

import java.util.HashMap;

public int sumOfUnique(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();

    // Count frequency
    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    int sum = 0;

    // Sum unique elements
    for (int num : map.keySet()) {
        if (map.get(num) == 1) {
            sum += num;
        }
    }

    return sum;
}
