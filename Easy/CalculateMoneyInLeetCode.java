/*
Question:
Hercy saves money daily. On Monday he puts $1, and each next day he adds $1 more.
Every new week (Monday), he starts with $1 more than previous Monday.
Given n days, return total money saved.
*/

public class Main {
    public static int totalMoney(int n) {
        int total = 0;
        int weekStart = 1; // money on Monday

        for (int i = 1; i <= n; i++) {
            total += weekStart + (i - 1) % 7;

            // if new week starts
            if (i % 7 == 0) {
                weekStart++;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(4));   // 10
        System.out.println(totalMoney(10));  // 37
        System.out.println(totalMoney(20));  // 96
    }
}
