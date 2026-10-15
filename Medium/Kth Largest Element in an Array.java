/*# LeetCode 215 — Kth Largest Element in an Array

**Difficulty:** Medium  
**Topics:** Array, Heap (Priority Queue), Quickselect  
**Approach:** Min Heap  
**Time Complexity:** O(n log k)  
**Space Complexity:** O(k)

## Problem
Given an integer array `nums` and an integer `k`, return the kth largest element in the sorted order. The element does not need to be distinct.

**Example**
```text
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```
## Logic
1. Create a min heap using `PriorityQueue`.
2. Insert each array element into the heap.
3. If the heap size exceeds `k`, remove the smallest element.
4. After processing all elements, the heap contains the `k` largest elements.
5. Return the heap's smallest element, which is the kth largest.

## Complexity Analysis
- **Time Complexity:** O(n log k), because each insertion or removal takes O(log k).
- **Space Complexity:** O(k), because the heap stores at most k elements.

## Key Point
This solution finds the kth largest element **without sorting the entire array** and correctly handles duplicate values.
## Java Solution
```java*/
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Process each element of the array
        for (int num : nums) {
            minHeap.offer(num);

            // Remove the smallest element if heap size exceeds k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The smallest element among the k largest is kth largest
        return minHeap.peek();
    }
}
```

