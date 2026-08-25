    /*
     * Question:
     * Find the minimum number of bit flips needed to make
     * the binary representation of n equal to its reverse.
     */
class Solution {

    public int minimumFlips(int n) {

        String s = Integer.toBinaryString(n);
        int flips = 0;

        // Compare symmetric bits
        for (int i = 0; i < s.length() / 2; i++) {

            int j = s.length() - 1 - i;

            // If symmetric bits are different,
            // both positions must be flipped.
            if (s.charAt(i) != s.charAt(j)) {
                flips += 2;
            }
        }

        return flips;
    }
}
