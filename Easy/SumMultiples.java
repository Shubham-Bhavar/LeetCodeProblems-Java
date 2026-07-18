    /*
    ❓ Goal: Find sum of numbers from 1 to n
    ❓ Condition: divisible by 3 OR 5 OR 7
    ❓ Method: loop from 1 to n → check → add
    ❓ Return: total sum
    */
class Solution {

    public int sumOfMultiples(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {

            // check divisibility
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
