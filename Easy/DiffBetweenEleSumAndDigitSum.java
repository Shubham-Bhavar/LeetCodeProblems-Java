// Question:
// Find absolute difference between element sum and digit sum

class Solution {
    public int differenceOfSum(int[] nums) {
        
        int elementSum = 0;
        int digitSum = 0;

        for (int num : nums) {
            
            // add to element sum
            elementSum += num;

            // find digit sum of each number
            while (num > 0) {
                digitSum += num % 10;  // last digit
                num /= 10;             // remove last digit
            }
        }

        // return absolute difference
        return Math.abs(elementSum - digitSum);
    }
}
