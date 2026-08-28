/*
LeetCode 2363: Merge Similar Items

Problem:
You are given two 2D arrays where each item is:
[value, weight]

Merge items having the same value by adding their weights.
Return the result sorted in ascending order by value.

Example:
items1 = [[1,1],[4,5],[3,8]]
items2 = [[3,1],[1,5]]

Merged result:
value 1 -> 1 + 5 = 6
value 3 -> 8 + 1 = 9
value 4 -> 5

Output: [[1,6],[3,9],[4,5]]

Logic:
1. Store each value and its total weight using an array.
2. Add weights from items1.
3. Add weights from items2.
4. Traverse values in ascending order.
5. Add every non-zero value and weight to the result.

Time Complexity: O(n + m + 1001)
Space Complexity: O(1001)
*/

class Solution {
    public List<List<Integer>> mergeSimilarItems(
            int[][] items1, int[][] items2) {

        int[] weight = new int[1001];

        // Add items1 weights
        for (int[] item : items1) {
            weight[item[0]] += item[1];
        }

        // Add items2 weights
        for (int[] item : items2) {
            weight[item[0]] += item[1];
        }

        List<List<Integer>> result = new ArrayList<>();

        // Values are added in ascending order
        for (int value = 1; value <= 1000; value++) {
            if (weight[value] > 0) {
                result.add(Arrays.asList(value, weight[value]));
            }
        }

        return result;
    }
}
