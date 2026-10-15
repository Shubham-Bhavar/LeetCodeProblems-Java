
/*
 * LeetCode 206: Reverse Linked List
 *
 * Problem:
 * Reverse a singly linked list and return its new head.
 *
 * Approach: Iterative
 * 1. Initialize prev = null and curr = head.
 * 2. Save the next node.
 * 3. Reverse the current node's link.
 * 4. Move prev and curr forward.
 * 5. Return prev as the new head.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

// ListNode is provided by LeetCode.

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
