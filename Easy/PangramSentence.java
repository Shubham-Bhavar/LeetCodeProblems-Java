/*
Question:
Check if a string is a pangram (contains all 26 alphabets).
*/

import java.util.*;

public class Main {
    public static boolean isPangram(String sentence) {
        Set<Character> set = new HashSet<>();

        for (char ch : sentence.toCharArray()) {
            set.add(ch);
        }

        return set.size() == 26;
    }

    public static void main(String[] args) {
        System.out.println(isPangram("thequickbrownfoxjumpsoverthelazydog")); // true
        System.out.println(isPangram("leetcode")); // false
    }
}
