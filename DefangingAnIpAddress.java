/*
Question:
Given a valid IP address, replace every "."
with "[.]".

Example:
Input:  "1.1.1.1"
Output: "1[.]1[.]1[.]1"
*/

class Solution {

    public String defangIPaddr(String address) {

        // Replace every dot with "[.]"
        return address.replace(".", "[.]");
    }
}
