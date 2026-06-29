// Question:
// Return total number of matches in tournament

class Solution {
    public int numberOfMatches(int n) {
        return n - 1;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.numberOfMatches(7));   // 6
        System.out.println(obj.numberOfMatches(14));  // 13
    }
}
