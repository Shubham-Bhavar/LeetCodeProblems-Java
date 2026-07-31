/*
Question (Short):
From array nums, Alice can choose either all single-digit numbers (1–9)
or all double-digit numbers (10–99).

If sum of chosen numbers > sum of remaining numbers, return true,
else return false.
*/

public class AliceGame {

    public static boolean canAliceWin(int[] nums) {
        int singleSum = 0;
        int doubleSum = 0;

        // Calculate sums
        for (int num : nums) {
            if (num < 10) {
                singleSum += num;
            } else {
                doubleSum += num;
            }
        }

        // Check if Alice can win
        return (singleSum > doubleSum) || (doubleSum > singleSum);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,10};
        System.out.println(canAliceWin(nums1)); // false

        int[] nums2 = {1,2,3,4,5,14};
        System.out.println(canAliceWin(nums2)); // true

        int[] nums3 = {5,5,5,25};
        System.out.println(canAliceWin(nums3)); // true
    }
}
