
/*
 * LeetCode 25. Reverse Nodes in k-Group
 *
 * Description:
 * Reverse the linked list in groups of k nodes.
 * Keep the remaining nodes unchanged if fewer than k
 * nodes are left.
 *
 * Approach: Recursion + Linked List Reversal
 * Time Complexity: O(n)
 * Space Complexity: O(n/k) due to recursion
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        // Check whether k nodes are available
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Reverse only if k nodes are available
        if (count == k) {
            curr = reverseKGroup(curr, k);

            // Reverse the current group
            while (count > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
                count--;
            }

            return curr;
        }

        return head;
    }
}
