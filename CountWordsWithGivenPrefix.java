/*
Question:
Given an array of strings, count how many strings start with given prefix.
*/

public class Main {
    public static int prefixCount(String[] words, String pref) {
        int count = 0;

        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] words1 = {"pay","attention","practice","attend"};
        System.out.println(prefixCount(words1, "at")); // 2

        String[] words2 = {"leetcode","win","loops","success"};
        System.out.println(prefixCount(words2, "code")); // 0
    }
}
