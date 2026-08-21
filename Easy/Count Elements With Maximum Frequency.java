/*
Question: Count Elements With Maximum Frequency

Return the total frequency of all elements that have
the maximum frequency.

Example:
nums = [1,2,2,3,1,4]

Frequency:
1 -> 2
2 -> 2
3 -> 1
4 -> 1

Maximum frequency = 2

Elements with maximum frequency: 1 and 2
Total frequency = 2 + 2 = 4
*/

class Solution {
    public int maxFrequencyElements(int[] nums) {

        int[] freq = new int[101];

        // Count frequency of each element
        for (int num : nums) {
            freq[num]++;
        }

        // Find maximum frequency
        int max = 0;

        for (int count : freq) {
            max = Math.max(max, count);
        }

        // Add frequencies equal to maximum frequency
        int answer = 0;

        for (int count : freq) {
            if (count == max) {
                answer += count;
            }
        }

        return answer;
    }
}
