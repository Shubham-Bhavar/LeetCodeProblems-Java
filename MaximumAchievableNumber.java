

class Solution {
    public int theMaximumAchievableX(int num, int t) {
        
        // Each operation changes the gap between x and num by 2
        
        // Therefore, after t operations:
        // x = num + 2*t
        //for simplification x-t=num+1;
        
        return num + (2 * t);
    }
}
