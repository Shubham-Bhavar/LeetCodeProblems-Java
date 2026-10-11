/*
 * LeetCode 237: Delete Node in a Linked List
 *
 * Problem:
 * Delete the given node without accessing the head of the list.
 * The given node is guaranteed not to be the last node.
 *
 * Example 1:
 * Input:  head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 *
 * Example 2:
 * Input:  head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 *
 * Approach:
 * 1. Copy the next node's value into the current node.
 * 2. Skip the next node by updating the next pointer.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *     }
 * }
 */

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
