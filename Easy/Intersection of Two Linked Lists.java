/*
 * LeetCode: 160. Intersection of Two Linked Lists
 *
 * Problem:
 * Given the heads of two singly linked lists headA and headB,
 * return the node at which the two lists intersect.
 *
 * If the two linked lists have no intersection, return null.
 *
 * Important:
 * Intersection means the SAME NODE REFERENCE, not just the same value.
 *
 * Example 1:
 * Input:
 * listA = [4,1,8,4,5]
 * listB = [5,6,1,8,4,5]
 *
 * Output:
 * Intersected at '8'
 *
 * Example 2:
 * Input:
 * listA = [1,9,1,2,4]
 * listB = [3,2,4]
 *
 * Output:
 * Intersected at '2'
 *
 * Example 3:
 * Input:
 * listA = [2,6,4]
 * listB = [1,5]
 *
 * Output:
 * No intersection
 *
 * ---------------------------------------------------------
 * Approach: Two Pointers
 * ---------------------------------------------------------
 *
 * Let:
 *   Length of list A = m
 *   Length of list B = n
 *
 * Pointer A traverses:
 *   A → B
 *
 * Pointer B traverses:
 *   B → A
 *
 * After switching lists, both pointers travel exactly
 * the same total distance.
 *
 * Therefore, if an intersection exists, they will meet
 * at the intersection node.
 *
 * If there is no intersection, both pointers will eventually
 * become null at the same time.
 *
 * Time Complexity:
 * O(m + n)
 *
 * Space Complexity:
 * O(1)
 */

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {

            // Move pointer A
            if (pointerA == null) {
                pointerA = headB;
            } else {
                pointerA = pointerA.next;
            }

            // Move pointer B
            if (pointerB == null) {
                pointerB = headA;
            } else {
                pointerB = pointerB.next;
            }
        }

        // Either the intersection node or null
        return pointerA;
    }
}
