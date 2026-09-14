```java
/*
    LeetCode 75 - Sort Colors

    Problem:
    Given an array nums containing 0, 1, and 2, sort the array
    in-place so that:
    
    0 -> Red
    1 -> White
    2 -> Blue

    The order must be:
    0, 1, 2

    Do not use the library's sort function.

    Example 1:
    Input:
    nums = [2,0,2,1,1,0]

    Output:
    [0,0,1,1,2,2]


    Example 2:
    Input:
    nums = [2,0,1]

    Output:
    [0,1,2]


    Approach:
    Use three pointers:

    low  -> position where the next 0 should go
    mid  -> current element
    high -> position where the next 2 should go

    Rules:
    1. nums[mid] == 0
       Swap nums[low] and nums[mid]
       Move low and mid

    2. nums[mid] == 1
       Just move mid

    3. nums[mid] == 2
       Swap nums[mid] and nums[high]
       Move high only

    Why don't we move mid after swapping with high?
    Because the element coming from high has not been checked yet.


    Example:
    [2,0,2,1,1,0]

    After processing:
    [0,0,1,1,2,2]


    Complexity:
    Time  : O(n)
    Space : O(1)

    Pattern:
    0 -> left
    1 -> middle
    2 -> right
*/

class Solution {
    public void sortColors(int[] nums) 
    {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high)
        {
            if(nums[mid] == 0)
            {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1)
            {
                mid++;
            }
            else
            {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
