    /*
    ❓ Goal: Create array arr based on game rules
    ❓ Step 1: Sort the array
    ❓ Step 2: Take 2 smallest elements each round
    ❓ Step 3: Add second (Bob) first, then first (Alice)
    ❓ Return: final arr
    */
import java.util.*;

class Solution {
  
    public int[] numberGame(int[] nums) {

        Arrays.sort(nums); // sort ascending
        int[] arr = new int[nums.length];

        int j = 0;

        for (int i = 0; i < nums.length; i += 2) {

            // Bob adds second smallest
            arr[j++] = nums[i + 1];

            // Alice adds smallest
            arr[j++] = nums[i];
        }

        return arr;
    }
}
