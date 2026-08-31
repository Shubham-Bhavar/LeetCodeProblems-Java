/*
===========================================================
LeetCode - Distribute Elements Into Two Arrays I
===========================================================

PROBLEM:
Given an array nums, distribute its elements into arr1
and arr2.

Rules:
1. nums[0] goes to arr1.
2. nums[1] goes to arr2.
3. For every next element:
   - If last element of arr1 > last element of arr2,
     add the element to arr1.
   - Otherwise, add it to arr2.
4. Return arr1 followed by arr2.

-----------------------------------------------------------
EXAMPLE:
-----------------------------------------------------------

nums = [5, 4, 3, 8]

Start:
arr1 = [5]
arr2 = [4]

3:
5 > 4 -> arr1
arr1 = [5, 3]

4:
3 > 4 is false -> arr2
arr2 = [4, 8]

Result:
[5, 3, 4, 8]

-----------------------------------------------------------
LOGIC:
-----------------------------------------------------------

Use ArrayList because we need to add elements dynamically.

After building arr1 and arr2:
Create result array.

First copy all elements of arr1.
Then copy all elements of arr2.

===========================================================
*/

class Solution {
    public int[] resultArray(int[] nums) {

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {

            if (arr1.get(arr1.size() - 1) >
                arr2.get(arr2.size() - 1)) {

                arr1.add(nums[i]);

            } else {

                arr2.add(nums[i]);
            }
        }

        int[] result = new int[nums.length];
        int index = 0;

        for (int x : arr1) {
            result[index++] = x;
        }

        for (int x : arr2) {
            result[index++] = x;
        }

        return result;
    }
}
