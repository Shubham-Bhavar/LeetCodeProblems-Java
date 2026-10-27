/*
 * LeetCode 1472: Design Browser History
 *
 * Question:
 * Implement browser history with visit, back, and forward operations.
 *
 * Approach:
 * 1. Store URLs in an ArrayList.
 * 2. Use current to track the current page.
 * 3. visit() removes forward history and adds the new URL.
 * 4. back() moves backward, stopping at index 0.
 * 5. forward() moves forward, stopping at the last URL.
 *
 * Time Complexity: O(n) for visit, O(1) for back/forward.
 * Space Complexity: O(n), where n is the number of stored URLs.
 */

import java.util.*;

class BrowserHistory {
    ArrayList<String> history = new ArrayList<>();
    int current = 0;

    public BrowserHistory(String homepage) {
        history.add(homepage);
    }

    public void visit(String url) {
        history.subList(current + 1, history.size()).clear();
        history.add(url);
        current++;
    }

    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history.get(current);
    }

    public String forward(int steps) {
        current = Math.min(history.size() - 1, current + steps);
        return history.get(current);
    }
}
