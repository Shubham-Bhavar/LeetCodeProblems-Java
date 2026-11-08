
/*
 * LeetCode 895. Maximum Frequency Stack
 *
 * Problem:
 * Design a stack that removes the most frequent element.
 * If frequencies are equal, remove the most recently pushed element.
 *
 * Approach:
 * 1. Use a HashMap to store element frequencies.
 * 2. Use another HashMap to maintain stacks grouped by frequency.
 * 3. Track the maximum frequency using maxFreq.
 * 4. Push and pop elements based on their frequency groups.
 *
 * Time Complexity:
 * Push: O(1)
 * Pop:  O(1)
 *
 * Space Complexity: O(n)
 */

import java.util.*;

class FreqStack {

    private Map<Integer, Integer> frequency;
    private Map<Integer, Stack<Integer>> group;
    private int maxFreq;

    public FreqStack() {
        frequency = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        // Increase frequency
        int freq = frequency.getOrDefault(val, 0) + 1;
        frequency.put(val, freq);

        // Update maximum frequency
        maxFreq = Math.max(maxFreq, freq);

        // Add element to its frequency group
        group.putIfAbsent(freq, new Stack<>());
        group.get(freq).push(val);
    }

    public int pop() {
        // Get the stack with maximum frequency
        Stack<Integer> stack = group.get(maxFreq);

        // Remove the most recently pushed element
        int val = stack.pop();

        // Decrease its frequency
        frequency.put(val, frequency.get(val) - 1);

        // Update maximum frequency if group becomes empty
        if (stack.isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}
