/*Q) Given a string word with distinct lowercase letters.

You can remap letters to keys (2–9). Each key can have multiple letters.
Typing cost:
- 1st letter on a key → 1 push
- 2nd letter → 2 pushes
- 3rd letter → 3 pushes
...

Return minimum total pushes to type the word.*/

class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0;

        for (int i = 0; i < n; i++) {
            pushes += (i / 8) + 1;
        }

        return pushes;
    }
}
