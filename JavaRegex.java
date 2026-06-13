/*Write a regex pattern to validate an IPv4 address.

A valid IP address:

Has 4 parts separated by .
Each part is between 0 and 255
Leading zeros are allowed

Example:

121.234.12.12  -> true
666.666.23.23  -> false*/

import java.util.Scanner;
class Solution
{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {

            String IP = in.next();

            // Check whether IP matches the regex pattern
            System.out.println(IP.matches(new MyRegex().pattern));
        }

        in.close();
    }
}

class MyRegex 
{
    // Matches a valid IPv4 address
    // Range of each part: 0 - 255
    String pattern =
        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)" +
        "(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}";
}
