// Q: What is the goal?
// A: Reverse substring from 0 to first occurrence of ch

class Solution {
    public String reversePrefix(String word, char ch) {
        
        char[] s = word.toCharArray();
        int index = -1;

        // Find first occurrence of ch
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ch) {
                index = i;
                break;
            }
        }

        // If not found, return original
        if (index == -1) {
            return word;
        }

        int left = 0, right = index;

        // Reverse from 0 to index
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

        // Return modified string
        return new String(s);
    }
}
