/*
Question:
Interpret the Goal Parser command.

Rules:
"G"    -> "G"
"()"   -> "o"
"(al)" -> "al"

Example:
Input: "G()(al)"
Output: "Goal"
*/

class Solution {

    public String interpret(String command) {

        // Replace "()" with "o"
        command = command.replace("()", "o");

        // Replace "(al)" with "al"
        command = command.replace("(al)", "al");

        // Return final interpreted string
        return command;
    }
}
