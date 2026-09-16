    /*
        LeetCode 83 - Remove Duplicates from Sorted List

        Problem:
        ----------
        Given the head of a sorted linked list,
        remove duplicate values so that each value
        appears only once.

        Example 1:
        Input:  [1,1,2]
        Output: [1,2]

        Example 2:
        Input:  [1,1,2,3,3]
        Output: [1,2,3]


        Approach:
        ----------
        The list is already sorted.

        Therefore, duplicate values are always next
        to each other.

        We use one pointer: current

        Compare:
            current.val == current.next.val

        If they are equal:
            Skip the duplicate node.

        Otherwise:
            Move current to the next node.


        Example:
        --------
        [1,1,2,3,3]

        current = 1
        next    = 1
        Same → skip duplicate

        List becomes:
        [1,2,3,3]

        current = 2
        next    = 3
        Different → move forward

        current = 3
        next    = 3
        Same → skip duplicate

        Final:
        [1,2,3]


        Important:
        ----------
        To remove a duplicate:

            current.next = current.next.next

        This makes current point directly
        to the node after the duplicate.


        Time Complexity:
        ----------------
        O(n)

        We visit each node at most once.


        Space Complexity:
        -----------------
        O(1)

        No extra data structure is used.
    */
class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        // Empty list or only one node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;

        // Traverse the linked list
        while (current != null && current.next != null) {

            // If current and next have the same value
            if (current.val == current.next.val) {

                // Remove the duplicate node
                current.next = current.next.next;
            }
            else {

                // Move to the next node
                current = current.next;
            }
        }

        return head;
    }
}
