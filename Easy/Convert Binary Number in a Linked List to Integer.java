/*
 * Problem: 1290. Convert Binary Number in a Linked List to Integer
 * Difficulty: Easy
 * Language: Java
 *
 * Approach:
 * Traverse the linked list and convert binary to decimal.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int getDecimalValue(ListNode head) {
        int result = 0;

        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }

        return result;
    }
}
