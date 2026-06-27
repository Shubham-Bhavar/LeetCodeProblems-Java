// Q: What is the goal?
// A: Add elements at even indices, subtract at odd indices

// Q: Key idea?
// A: If index % 2 == 0 → add, else → subtract

class Solution {
    public int alternatingSum(int[] nums) {
        
        int sum = 0;

        // Traverse array
        for (int i = 0; i < nums.length; i++) {
            
            if (i % 2 == 0) {
                sum += nums[i];  // even index → add
            } else {
                sum -= nums[i];  // odd index → subtract
            }
        }

        return sum;
    }
}
