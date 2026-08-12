/*
Question:
Given a date in the format "yyyy-mm-dd",
convert the year, month, and day into binary.

Return the binary representation in the same format:
year-month-day

Example:
Input:  "2080-02-29"
Output: "100000100000-10-11101"

Approach:
1. Extract year, month, and day from the string.
2. Convert each value to binary.
3. Join them using '-'.
*/

class Solution {
    public String convertDateToBinary(String date) {

        // Extract year, month, and day
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        // Convert each value to binary
        String binaryYear = Integer.toBinaryString(year);
        String binaryMonth = Integer.toBinaryString(month);
        String binaryDay = Integer.toBinaryString(day);

        // Return in year-month-day format
        return binaryYear + "-" + binaryMonth + "-" + binaryDay;
    }
}
