/*
====================================================================
LeetCode 2807 - Insert Greatest Common Divisors in Linked List
====================================================================

Problem Statement:
------------------
Given the head of a linked list, where each node contains an
integer value.

Between every pair of adjacent nodes, insert a new node whose
value is equal to the Greatest Common Divisor (GCD) of those
two adjacent nodes.

Return the linked list after all required insertions.

The Greatest Common Divisor (GCD) of two numbers is the largest
positive integer that divides both numbers without leaving a
remainder.

--------------------------------------------------------------------
Example 1:
--------------------------------------------------------------------

Input:
head = [18, 6, 10, 3]

Adjacent pairs:
(18, 6)  -> GCD = 6
(6, 10)  -> GCD = 2
(10, 3)  -> GCD = 1

Output:
[18, 6, 6, 2, 10, 1, 3]

Explanation:

Original List:
18 -> 6 -> 10 -> 3

Insert GCD(18, 6):
18 -> 6 -> 6 -> 10 -> 3

Insert GCD(6, 10):
18 -> 6 -> 6 -> 2 -> 10 -> 3

Insert GCD(10, 3):
18 -> 6 -> 6 -> 2 -> 10 -> 1 -> 3


--------------------------------------------------------------------
Example 2:
--------------------------------------------------------------------

Input:
head = [7]

Output:
[7]

Explanation:
There is only one node, so there is no pair of adjacent nodes.
Therefore, no new node is inserted.

--------------------------------------------------------------------
Constraints:
--------------------------------------------------------------------

1. Number of nodes is in the range [1, 5000].
2. 1 <= Node.val <= 1000.

--------------------------------------------------------------------
Approach:
--------------------------------------------------------------------

We traverse the linked list using a pointer called 'curr'.

For every pair:

        curr       curr.next
          |            |
          v            v
         [18] ->      [6]

1. Find GCD of curr.val and curr.next.val.
2. Create a new node containing the GCD.
3. Insert this new node between curr and curr.next.
4. Move curr to the original next node.

The fourth step is very important.

After inserting a node:

        curr
          |
          v
         [18] -> [6(GCD)] -> [6] -> [10]

We should move curr to the original next node:

                    curr
                      |
                      v
         [18] -> [6] -> [6] -> [10]

This is done using:

        curr = newN.next;

Otherwise, curr would remain on the same node and the same
pair could be processed repeatedly.

--------------------------------------------------------------------
GCD Algorithm:
--------------------------------------------------------------------

We use the Euclidean Algorithm.

For two numbers a and b:

        while(b != 0)
        {
            a % b
        }

Example:

GCD(18, 6)

18 % 6 = 0

Therefore:
GCD = 6


Another example:

GCD(10, 3)

10 % 3 = 1
3 % 1 = 0

Therefore:
GCD = 1

--------------------------------------------------------------------
Time Complexity:
--------------------------------------------------------------------

There are n nodes.

We process every adjacent pair once.

GCD takes O(log(min(a,b))) time.

Overall:

        O(n log V)

where V is the maximum node value.

Since node values are at most 1000, this is effectively
very efficient.

--------------------------------------------------------------------
Space Complexity:
--------------------------------------------------------------------

We create one new node for every adjacent pair.

This is required for the output itself.

Extra auxiliary space:

        O(1)

--------------------------------------------------------------------
Key Points:
--------------------------------------------------------------------

1. Use curr and curr.next to access adjacent nodes.
2. Use Euclidean Algorithm to calculate GCD.
3. Insert the new node between the two nodes.
4. Move curr to newN.next after insertion.
5. A single-node list needs no modification.
====================================================================
*/

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) 
    {
        ListNode curr = head;

        // Traverse while there is an adjacent node
        while(curr != null && curr.next != null)
        {
            // Find GCD of current and next node
            int gcd = Gcd(curr.val, curr.next.val);

            // Create new node containing GCD
            ListNode newN = new ListNode(gcd);

            // Connect new node to original next node
            newN.next = curr.next;

            // Connect current node to new node
            curr.next = newN;

            // Move to the original next node
            curr = newN.next;
        }

        return head;
    }

    // Euclidean Algorithm to find GCD
    private int Gcd(int a, int b)
    {
        while(b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
