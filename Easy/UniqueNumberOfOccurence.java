/*
Question:
Check if frequency of each element is unique.

Example:
Input: [1,2,2,1,1,3]
Output: true

Name: Shubham Bhavar
*/

import java.util.*;

public class Main {

    public static boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check uniqueness using Set
        HashSet<Integer> set = new HashSet<>();

        for (int freq : map.values()) {
            if (set.contains(freq)) {
                return false;
            }
            set.add(freq);
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Result: " + uniqueOccurrences(arr));

        sc.close();
    }
}
