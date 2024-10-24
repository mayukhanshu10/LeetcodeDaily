class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int sum = 0;
        int n = arr.length;
        
        // Calculate the sum of the array
        for (int i : arr) {
            sum += i;
        }

        // If sum < target or if (sum + target) is odd, return 0
        if (sum < Math.abs(target) || (target + sum) % 2 != 0) {
            return 0;
        }
        
        // Calculate the subset sum we are targeting
        int newTarget = (target + sum) / 2;

        // Create DP table
        int[][] dp = new int[n + 1][newTarget + 1];

        // Initialize the DP table
        // There's 1 way to achieve sum 0 (by picking no elements)
        dp[0][0] = 1;

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= newTarget; j++) {
                // Don't pick the current element
                dp[i][j] = dp[i - 1][j];

                // Pick the current element if it's less than or equal to j
                if (arr[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        
        return dp[n][newTarget];  // Return the count of subsets with the desired sum
    }
}
