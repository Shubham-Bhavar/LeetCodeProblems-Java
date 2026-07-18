/*
Question:
Count how many stones are jewels.
*/

class Solution {

    public int numJewelsInStones(String jewels, String stones) {

        int count = 0;

        // Check every jewel
        for (int i = 0; i < jewels.length(); i++) {

            char jewel = jewels.charAt(i);

            // Check every stone
            for (int j = 0; j < stones.length(); j++) {

                if (jewel == stones.charAt(j)) {
                    count++;
                }
            }
        }

        return count;
    }
}
