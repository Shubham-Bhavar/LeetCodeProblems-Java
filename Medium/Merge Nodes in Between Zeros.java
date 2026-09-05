/*
===========================================================
LeetCode 2181 - Merge Nodes in Between Zeros
===========================================================

Problem:
Given a linked list containing integers separated by 0's,
merge all nodes between every two consecutive 0's into one
node whose value is their sum.

The first and last nodes are always 0.

Example:
Input:  0 -> 3 -> 1 -> 0 -> 4 -> 5 -> 2 -> 0
Output: 4 -> 11

Explanation:
3 + 1     = 4
4 + 5 + 2 = 11

-----------------------------------------------------------
Approach:
-----------------------------------------------------------
1. Traverse the linked list using curr.
2. Add every non-zero value to sum.
3. When 0 is found, the current group is complete.
4. Create a new node with the calculated sum.
5. Attach it to the result list.
6. Reset sum = 0 for the next group.
7. Use a dummy node to easily build the result list.

-----------------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(1) extra space
-----------------------------------------------------------
*/

class Solution {
    public ListNode mergeNodes(ListNode head) 
    {
        // Dummy node for result list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int sum = 0;
        ListNode curr = head;

        while(curr != null)
        {
            if(curr.val != 0)
            {
                // Add value to current group
                sum += curr.val;
            }
            else
            {
                // Group completed
                if(sum > 0)
                {
                    ListNode newNode = new ListNode(sum);

                    tail.next = newNode;
                    tail = newNode;

                    // Start next group
                    sum = 0;
                }
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
