/*
 * LeetCode 61: Rotate List
 *
 * Problem:
 * Given the head of a linked list, rotate the list to the right
 * by k places.
 *
 * Example 1:
 * Input:  head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * Example 2:
 * Input:  head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 * Approach:
 * 1. Find the length of the linked list.
 * 2. Connect the last node to the head to make a circular list.
 * 3. Since rotating n times gives the original list:
 *      k = k % n
 * 4. Find the new tail at position n - k - 1.
 * 5. The next node is the new head.
 * 6. Break the circular connection.
 *
 * Example:
 * [1,2,3,4,5], k = 2
 *
 * New head = 4
 * Result = [4,5,1,2,3]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and last node
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Avoid unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Make the list circular
        tail.next = head;

        // Find new tail
        int steps = length - k;
        ListNode newTail = tail;

        for (int i = 0; i < steps; i++) {
            newTail = newTail.next;
        }

        // New head is after new tail
        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}
