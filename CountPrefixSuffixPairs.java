    /*
    ❓ Goal: Count pairs (i, j) where i < j
    ❓ Condition: words[i] is BOTH prefix & suffix of words[j]
    ❓ Check: startsWith() + endsWith()
    ❓ Return: total count
    */
class Solution {

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        // Check all pairs
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {

                // Check prefix + suffix
                if (words[j].startsWith(words[i]) && 
                    words[j].endsWith(words[i])) {
                    count++;
                }
            }
        }

        return count;
    }
}
