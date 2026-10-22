/**
 * LeetCode 2014: Longest Subsequence Repeated k Times
 *
 * Approach:
 * 1. Count the frequency of each character.
 * 2. Keep characters that appear at least k times.
 * 3. Use BFS to generate candidate subsequences.
 * 4. Check whether each candidate repeated k times
 *    is a subsequence of the original string.
 * 5. Return the longest valid candidate.
 *    For equal lengths, choose the lexicographically
 *    largest candidate.
 *
 * Time Complexity: Exponential in the maximum answer length.
 * Space Complexity: Depends on the number of candidates.
 */
import java.util.*;

class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];

        // Count character frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Collect eligible characters in descending order
        List<Character> chars = new ArrayList<>();

        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                chars.add((char) ('a' + i));
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        String answer = "";

        // Generate valid subsequences using BFS
        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (char c : chars) {
                String candidate = current + c;

                if (isRepeatedSubsequence(s, candidate, k)) {
                    if (candidate.length() > answer.length()
                            || (candidate.length() == answer.length()
                            && candidate.compareTo(answer) > 0)) {
                        answer = candidate;
                    }

                    queue.offer(candidate);
                }
            }
        }

        return answer;
    }

    // Check whether seq repeated k times is a subsequence of s
    private boolean isRepeatedSubsequence(String s, String seq, int k) {
        int matched = 0;
        int target = seq.length() * k;

        for (char c : s.toCharArray()) {
            if (c == seq.charAt(matched % seq.length())) {
                matched++;

                if (matched == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
