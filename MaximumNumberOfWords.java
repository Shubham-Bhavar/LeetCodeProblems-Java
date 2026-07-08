/*
Question:
Given a string 'text' containing words separated by spaces and a string 'brokenLetters'
representing non-working keys, return the number of words that can be typed
without using any broken letters.
*/

import java.util.*;

public class Main {
    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        Set<Character> brokenSet = new HashSet<>();

        // Store broken letters
        for (char ch : brokenLetters.toCharArray()) {
            brokenSet.add(ch);
        }

        int count = 0;

        for (String word : words) {
            boolean canType = true;

            for (char ch : word.toCharArray()) {
                if (brokenSet.contains(ch)) {
                    canType = false;
                    break;
                }
            }

            if (canType) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(canBeTypedWords("hello world", "ad")); // 1
        System.out.println(canBeTypedWords("leet code", "lt"));   // 1
        System.out.println(canBeTypedWords("leet code", "e"));    // 0
    }
}
