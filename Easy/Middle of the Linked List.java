/*
LeetCode 876: Middle of the Linked List
Difficulty: Easy
Topics: Linked List, Two Pointers

Problem:
Return the middle node of a singly linked list.
If there are two middle nodes, return the second one.

Approach:
1. Use slow and fast pointers.
2. Move slow by one step and fast by two steps.
3. When fast reaches the end, slow points to the middle.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
