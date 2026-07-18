// Q: What is the goal?
// A: Maximize the number by changing at most one digit (6 → 9)

// Q: Key idea?
// A: Change the first (leftmost) '6' to '9' for maximum impact

// Q: Why first '6'?
// A: Leftmost digit has highest place value → gives biggest increase

class Solution {
    public int maximum69Number(int num) {
        
        // Convert number to char array for easy modification
        char[] digits = String.valueOf(num).toCharArray();
        
        // Traverse digits from left to right
        for (int i = 0; i < digits.length; i++) {
            
            // If we find '6', change it to '9'
            if (digits[i] == '6') {
                digits[i] = '9';
                
                // Only one change allowed → break
                break;
            }
        }
        
        // Convert back to integer and return result
        return Integer.parseInt(new String(digits));
    }
}
