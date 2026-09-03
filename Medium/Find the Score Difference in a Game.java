/*
LeetCode 3847 - Find the Score Difference in a Game

Problem:
You are given an integer array nums where nums[i] represents
the points scored in the ith game.

There are two players:
- Player 1 is initially active.
- Player 2 is initially inactive.

Rules:
1. If nums[i] is odd, active and inactive players swap.
2. In every 6th game (indices 5, 11, 17, ...),
   active and inactive players swap.
3. The active player gets nums[i] points.

Return:
Player 1 total score - Player 2 total score.

Example:
Input:  nums = [1,2,3]
Output: 0

Explanation:
Game 0: 1 is odd -> Player 2 gets 1
Game 1: Player 2 gets 2
Game 2: 3 is odd -> Player 1 gets 3

Player 1 = 3
Player 2 = 3
Difference = 3 - 3 = 0


Approach:
- Use active to track the current player.
- active = 0 -> Player 1
- active = 1 -> Player 2
- For every game:
    1. Swap if nums[i] is odd.
    2. Swap if i is a 6th-game index.
    3. Add points to the active player.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int scoreDifference(int[] nums) 
    {
        int player1 = 0;
        int player2 = 0;
        int active = 0;

        for(int i = 0; i < nums.length; i++)
        {
            // Odd score -> swap players
            if(nums[i] % 2 == 1)
            {
                active = 1 - active;
            }

            // Every 6th game -> swap players
            if(i % 6 == 5)
            {
                active = 1 - active;
            }

            // Add score to active player
            if(active == 0)
            {
                player1 += nums[i];
            }
            else
            {
                player2 += nums[i];
            }
        }

        return player1 - player2;
    }
}
