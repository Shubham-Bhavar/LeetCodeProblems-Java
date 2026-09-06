/*
Weighted Word Mapping

Problem:
For each word:
1. Calculate the sum of weights of its characters.
2. Take the sum modulo 26.
3. Map the result in reverse alphabetical order:
   0 -> 'z'
   1 -> 'y'
   2 -> 'x'
   ...
   25 -> 'a'

Example:
words = ["abcd"]
weights = [5,3,12,14,...]

Weight = 5 + 3 + 12 + 14 = 34
34 % 26 = 8
8 -> 'r'

Output: "r"

Approach:
- Use character - 'a' to get the index in weights.
- Calculate each word's total weight.
- Convert modulo result using:
  'z' - remainder

Time Complexity: O(total characters)
Space Complexity: O(words.length)
*/

class Solution {
    public String weightedWordMapping(String[] words, int[] weights) 
    {
        StringBuilder ans = new StringBuilder();

        for(String word : words)
        {
            int sum = 0;

            for(char ch : word.toCharArray())
            {
                sum += weights[ch - 'a'];
            }

            int remainder = sum % 26;

            // Reverse alphabetical mapping
            char result = (char)('z' - remainder);

            ans.append(result);
        }

        return ans.toString();
    }
}
