// Problem: Merge Two Sorted Linked Lists (Recursive)
// Approach: Compare current nodes and recursively merge remaining lists
// Time Complexity: O(n + m)
// Space Complexity: O(n + m) (recursion stack)

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // base cases
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // choose smaller node
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
