/*Q) You are given a 2D integer array tasks where tasks[i] = [si, ti].

Each task starts at time si and takes ti time to finish.

Return the earliest time at which at least one task is finished.*/


  class Solution {
    public int earliestTime(int[][] tasks) {
        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < tasks.length; i++) {
            int finish = tasks[i][0] + tasks[i][1];
            minTime = Math.min(minTime, finish);
        }

        return minTime;
    }
}
