
/*
 * LeetCode 203: Remove Linked List Elements
 *
 * Problem:
 * Remove all nodes from the linked list
 * whose value is equal to val.
 *
 * Approach:
 * Use a Dummy Node and a Current Pointer.
 *
 * Step-by-step:
 * 1. Create a dummy node before the head.
 * 2. Set current to dummy.
 * 3. Check the next node's value.
 * 4. If it equals val, skip that node.
 * 5. Otherwise, move current forward.
 * 6. Return dummy.next.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public ListNode removeElements(ListNode head, int val) {

        // Create a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Start from dummy node
        ListNode current = dummy;

        // Traverse the linked list
        while (current.next != null) {

            if (current.next.val == val) {

                // Remove the matching node
                current.next = current.next.next;

            } else {

                // Move to the next node
                current = current.next;
            }
        }

        // Return the updated head
        return dummy.next;
    }
}
