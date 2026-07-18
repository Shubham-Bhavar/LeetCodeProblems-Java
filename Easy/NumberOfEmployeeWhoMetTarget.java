// Question:
// Count employees who worked at least target hours

class Solution {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {

        int count = 0;

        // loop through each employee
        for (int i = 0; i < hours.length; i++) {

            // check if employee meets target
            if (hours[i] >= target) {
                count++;
            }
        }

        return count;
    }
}
