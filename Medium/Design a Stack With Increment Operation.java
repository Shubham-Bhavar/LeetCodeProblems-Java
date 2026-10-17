/*
LeetCode 1381: Design a Stack With Increment Operation
Difficulty: Medium
Topics: Stack, Array, Design

Approach:
1. Use an array to implement the stack.
2. Push adds elements if the stack is not full; pop removes the top element.
3. Increment the bottom k elements by val.

Time Complexity:
push: O(1)
pop: O(1)
increment: O(k)

Space Complexity: O(maxSize)
*/

class CustomStack {
    private int[] stack;
    private int top;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top < maxSize - 1) {
            stack[++top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }

        return stack[top--];
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, top + 1);

        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
}
