class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        
        // Initialize dp array
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = amount + 2; // Set impossible cases for 0 coins
        }
        
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 0; // 0 coins needed to make amount 0
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                int np = dp[i - 1][j]; // Not picking the coin
                int p = amount + 2; // Initialize as a large value for comparison
                if (coins[i - 1] <= j) {
                    p = 1 + dp[i][j - coins[i - 1]]; // Picking the coin
                }
                dp[i][j] = Math.min(np, p);
            }
        }
        
        return dp[len][amount] > amount ? -1 : dp[len][amount];
    }
}
