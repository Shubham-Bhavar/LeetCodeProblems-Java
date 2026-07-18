/*
Problem: Find Friends in Their Finishing Order

Description:
Given the race finishing order and a list of friends' IDs,
return the friends' IDs in the order they finished the race.

Approach:
- Store all friends' IDs in a HashSet.
- Traverse the order array.
- If an ID belongs to a friend, add it to the result.
- Return the result array.

Time Complexity: O(n)
Space Complexity: O(f)
*/

class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {

        // Store friends' IDs for fast lookup
        Set<Integer> set = new HashSet<>();

        for (int friend : friends) {
            set.add(friend);
        }

        int[] result = new int[friends.length];
        int index = 0;

        // Traverse finishing order
        for (int id : order) {

            // If current ID is a friend
            if (set.contains(id)) {
                result[index++] = id;
            }
        }

        return result;
    }
}
