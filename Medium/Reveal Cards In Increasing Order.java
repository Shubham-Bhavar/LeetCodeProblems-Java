/*
LeetCode 950: Reveal Cards In Increasing Order
Difficulty: Medium
Topics: Array, Sorting, Queue, Simulation

Approach:
1. Sort the cards in ascending order.
2. Use a queue to simulate the positions of the cards.
3. Place each sorted card at the next reveal position.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int n = deck.length;
        int[] result = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        // Store all card positions
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        for (int card : deck) {
            // Place the smallest available card
            int index = queue.poll();
            result[index] = card;

            // Move the next position to the back
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        return result;
    }
}
