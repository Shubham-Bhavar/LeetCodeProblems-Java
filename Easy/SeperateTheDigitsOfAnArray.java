/**
 * 🧠 Problem:
 * Extract all digits from each number in nums
 * and return them in the same order.
 *
 * 📥 Input:
 * nums = [13,25,83,77]
 *
 * 📤 Output:
 * [1,3,2,5,8,3,7,7]
 *
 * ⚡ Approach:
 * - Convert each number to string
 * - Traverse characters and convert back to digits
 *
 * ⏱ Time: O(n * d)
 * ⏱ Space: O(n * d)
 */

class Solution {
    public int[] separateDigits(int[] nums) {

        java.util.List<Integer> list = new java.util.ArrayList<>();

        for (int num : nums) {
            for (char ch : String.valueOf(num).toCharArray()) {
                list.add(ch - '0');
            }
        }

        // convert list to array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
