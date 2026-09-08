/*
LeetCode 2 - Add Two Numbers

Approach:
- Add corresponding digits of both linked lists.
- Keep track of carry.
- Create a new node for each digit.
- Move curr to the newly created node.

Time Complexity: O(max(n, m))
Space Complexity: O(max(n, m)) for the result list
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node helps us easily build the result list
        ListNode dummy = new ListNode(0);

        // Stores carry from the previous addition
        int carry = 0;

        // curr points to the last node of the result list
        ListNode curr = dummy;

        // Continue until both lists and carry are finished
        while(l1 != null || l2 != null || carry != 0)
        {
            // Start sum with the carry
            int sum = carry;

            // Add digit from l1
            if(l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add digit from l2
            if(l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }

            // Create a new node with the last digit of sum
            curr.next = new ListNode(sum % 10);

            // Move curr to the newly created node
            curr = curr.next;

            // Calculate carry for the next addition
            carry = sum / 10;
        }

        // Return the actual result, skipping the dummy node
        return dummy.next;
    }
}
