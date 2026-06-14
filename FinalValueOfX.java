/*Final Value of Variable After Performing Operations
Question

Initially:

X = 0

You are given an array of operations.

Operations can be:

"++X"
"X++"
"--X"
"X--"

Return the final value of X.*/
class Solution {
    public int finalValueAfterOperations(String[] operations) {

        // Initial value of X
        int x = 0;

        // Traverse all operations
        for (String op : operations) {

            // Increment operation
            if (op.contains("++")) {
                x++;
            }
            // Decrement operation
            else {
                x--;
            }
        }

        return x;
    }
}
