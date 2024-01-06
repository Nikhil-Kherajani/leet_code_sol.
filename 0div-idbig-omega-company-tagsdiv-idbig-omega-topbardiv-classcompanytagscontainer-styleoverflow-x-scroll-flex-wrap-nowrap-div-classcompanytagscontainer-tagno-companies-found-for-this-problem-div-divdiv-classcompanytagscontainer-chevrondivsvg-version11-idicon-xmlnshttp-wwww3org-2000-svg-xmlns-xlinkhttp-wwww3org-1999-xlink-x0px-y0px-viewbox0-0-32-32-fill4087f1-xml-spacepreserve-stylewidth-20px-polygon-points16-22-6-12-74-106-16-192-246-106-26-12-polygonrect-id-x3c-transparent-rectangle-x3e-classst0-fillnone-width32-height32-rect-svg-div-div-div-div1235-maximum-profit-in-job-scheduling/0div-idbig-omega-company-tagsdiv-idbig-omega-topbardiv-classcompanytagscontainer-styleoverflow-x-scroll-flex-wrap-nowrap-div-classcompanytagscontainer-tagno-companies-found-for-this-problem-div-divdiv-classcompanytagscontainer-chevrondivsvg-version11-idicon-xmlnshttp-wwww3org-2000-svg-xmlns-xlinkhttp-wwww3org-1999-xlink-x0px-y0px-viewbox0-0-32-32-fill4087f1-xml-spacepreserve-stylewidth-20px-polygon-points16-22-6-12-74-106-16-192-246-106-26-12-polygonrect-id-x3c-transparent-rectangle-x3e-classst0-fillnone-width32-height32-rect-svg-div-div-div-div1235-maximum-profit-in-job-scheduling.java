class Solution {
    // Inner class to represent a job with its start time, end time, and profit
    class Pair {
        int start;
        int end;
        int profit;
        public Pair(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.profit = p;
        }
    }

    // Main function to find the maximum profit for scheduling jobs
    public int jobScheduling(int[] start, int[] end, int[] profit) {
        int len = profit.length;
        Pair arr[] = new Pair[len];
        Integer dp[] = new Integer[len + 1];

        // Creating an array of Pair objects to store job details
        for (int i = 0; i < len; i++) {
            arr[i] = new Pair(start[i], end[i], profit[i]);
        }

        // Sorting the jobs based on their start times
        Arrays.sort(arr, (a, b) -> a.start - b.start);

        // Calling the solve function to find the maximum profit
        return solve(arr, 0, dp);
    }

    // Helper function to find the next job that can be scheduled after the current job
    private int findNextJob(Pair arr[], int start, int currentJob) {
        int end = arr.length - 1;
        int result = arr.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid].start >= currentJob) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    // Recursive function to find the maximum profit for scheduling jobs
    private int solve(Pair arr[], int i, Integer dp[]) {
        // Base case: if all jobs are processed
        if (i == arr.length) return 0;
        // If the result for the current index is already calculated, return it
        if (dp[i] != null) return dp[i];

        // Find the next job that can be scheduled after the current job
        int next = findNextJob(arr, i + 1, arr[i].end);

        // Calculate the profit if the current job is taken
        int taken = arr[i].profit + solve(arr, next, dp);

        // Calculate the profit if the current job is not taken
        int notTaken = solve(arr, i + 1, dp);

        // Choose the maximum profit between taking and not taking the current job
        return dp[i] = Math.max(taken, notTaken);
    }
}
