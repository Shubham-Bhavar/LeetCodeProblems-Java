/*
LeetCode 24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes
and return its head.

Example:
Input:  1 -> 2 -> 3 -> 4
Output: 2 -> 1 -> 4 -> 3

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {

            ListNode first = current.next;
            ListNode second = current.next.next;

            // Swap nodes
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move to next pair
            current = first;
        }

        return dummy.next;
    }
}