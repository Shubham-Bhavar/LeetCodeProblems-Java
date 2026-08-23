    /*
     * Question:
     * Return true if the absolute difference between
     * every pair of adjacent digits is at most 2.
     */
class Solution {

    public boolean hasValidAdjacentDifference(String s) {

        for (int i = 0; i < s.length() - 1; i++) {

            // Convert adjacent characters to digits
            int first = s.charAt(i) - '0';
            int second = s.charAt(i + 1) - '0';

            // Check the absolute difference
            if (Math.abs(first - second) > 2) {
                return false;
            }
        }

        return true;
    }
}
